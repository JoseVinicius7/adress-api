package br.com.crcarvalho.addressapi.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.jose.addressapi.controller.dto.AddressDto;
import br.com.jose.addressapi.controller.dto.CoordinatesDto;
import br.com.jose.addressapi.controller.dto.GeocodingDto;
import br.com.jose.addressapi.controller.dto.GeometryDto;
import br.com.jose.addressapi.controller.dto.ResultDto;
import br.com.jose.addressapi.controller.form.AddressForm;
import br.com.jose.addressapi.entity.Address;
import br.com.jose.addressapi.exception.AddressNotFoundException;
import br.com.jose.addressapi.exception.GeocodingException;
import br.com.jose.addressapi.repository.AddressRepository;
import br.com.jose.addressapi.service.AddressService;
import br.com.jose.addressapi.service.AddressServiceImpl;
import br.com.jose.addressapi.service.GeocodingClient;

public class AddressServiceImplTest {
	
	private static final double LONGITUDE = -15.00001;

	private static final double LATITUDE = -30.00001;

	private static final long ADDRESS_ID = 1L;

	private static final int ZIP_CODE = 45800000;

	private static final String COUNTRY = "Brasil";

	private static final String STATE = "São Paulo";

	private static final String CITY = "São Paulo";

	private static final String NEIGHBOURDHOOD = "Centro";

	private static final String COMPLEMENT = "a";

	private static final int NUMBER = 123;

	private static final String STREET_NAME = "Avenida Paulista";

	private static final String API_KEY = "AIzaSyCj0cY2yEvVfYhAaTz3-P2MW-YRKmhz5Uw";

	private AddressRepository repository;
	
	private GeocodingClient geocodingClient;
	
	private AddressService service;
	
	@BeforeEach
	public void setUp() {
		repository = mock(AddressRepository.class);
		geocodingClient = mock(GeocodingClient.class);
		service = new AddressServiceImpl(repository, geocodingClient, API_KEY);
	}
	
	@Test
	public void shouldReturnAddressIdWhenSaveSuccessfully() {
		AddressForm form = getRequest();
		
		when(repository.save(any())).thenReturn(getExpected());
		when(geocodingClient.getGeocoding(any(), any())).thenReturn(getGeocoding());
		
		Address response = service.save(form);
		
		assertThat(response, equalTo(getExpected()));
	}
	
	@Test
	public void shouldThrowExceptionWhenCoordinateSearchFails() {
		AddressForm form = getRequest();
		
		when(geocodingClient.getGeocoding(any(), any())).thenThrow(new RuntimeException());
		
		GeocodingException ex = assertThrows(GeocodingException.class, () -> service.save(form));
		
		assertThat(ex.getMessage(), equalTo("Erro ao realizar busca de coordenadas, favor informar latitude e longitude"));
	}
	
	@Test
	public void shouldReturnAddressWhenSaveSuccessfully() {
		AddressForm form = getRequest();
		
		when(repository.save(any())).thenReturn(getExpected());
		when(geocodingClient.getGeocoding(any(), any())).thenReturn(getGeocoding());
		
		Address response = service.save(form);
		
		assertThat(response, equalTo(getExpected()));
	}
	
	@Test
	public void shouldReturnAddressWhenSearchSuccessfully() {
		
		when(repository.findById(any())).thenReturn(Optional.of(getExpected()));
		
		AddressDto response = service.getAddress(1L);
		
		assertThat(response, equalTo(new AddressDto(getExpected())));
	}
	
	@Test
	public void shouldThrowExceptionWhenSearchAddressNotFound() {
		
		when(repository.findById(any())).thenReturn(Optional.empty());
		
		AddressNotFoundException ex = assertThrows(AddressNotFoundException.class, () -> service.getAddress(1L));
		
		assertThat(ex.getMessage(), equalTo("Endereço de id: " + 1L + " não encontrado."));
	}

	private GeocodingDto getGeocoding() {
		GeocodingDto dto = new GeocodingDto();
		
		GeometryDto geometryDto = new GeometryDto();
		geometryDto.setLocation(new CoordinatesDto(LATITUDE, LONGITUDE));
		
		ResultDto resultDto = new ResultDto();		
		resultDto.setGeometry(geometryDto);
		
		dto.getResults().add(resultDto);
		
		return dto;
	}

	private Address getExpected() {
		Address address = new Address();
		address.setId(ADDRESS_ID);
		address.setStreetName(STREET_NAME);
		address.setNumber(NUMBER);
		address.setComplement(COMPLEMENT);
		address.setNeighbourdhood(NEIGHBOURDHOOD);
		address.setCity(CITY);
		address.setState(STATE);
		address.setCountry(COUNTRY);
		address.setZipcode(ZIP_CODE);
		address.setLatitude(LATITUDE);
		address.setLongitude(LONGITUDE);
		return address;
	}

	private AddressForm getRequest() {
		AddressForm form = new AddressForm();
		form.setStreetName(STREET_NAME);
		form.setNumber(NUMBER);
		form.setComplement(COMPLEMENT);
		form.setNeighbourdhood(NEIGHBOURDHOOD);
		form.setCity(CITY);
		form.setState(STATE);
		form.setCountry(COUNTRY);
		form.setZipcode(ZIP_CODE);
		return form;
	}
	
}
