package br.com.jose.addressapi.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.jose.addressapi.controller.dto.AddressDto;
import br.com.jose.addressapi.controller.dto.GeocodingDto;
import br.com.jose.addressapi.controller.form.AddressForm;
import br.com.jose.addressapi.entity.Address;
import br.com.jose.addressapi.exception.AddressNotFoundException;
import br.com.jose.addressapi.exception.GeocodingException;
import br.com.jose.addressapi.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {
	
	private AddressRepository addressRepository;
	
	private GeocodingClient client;
	
	private String geocodingKey;

	public AddressServiceImpl(AddressRepository addressRepository,
			GeocodingClient client,
			@Value("${geocoding.key}") String geocodingKey) {
		this.addressRepository = addressRepository;
		this.client = client;
		this.geocodingKey = geocodingKey;
	}

	@Override
	public List<AddressDto> getAll() {
		
		return addressRepository
				.findAll()
				.stream()
				.map(AddressDto::new)
				.collect(Collectors.toList());
		
	}

	@Override
	public AddressDto getAddress(Long id) {
		
		Address address = this.addressRepository
				.findById(id)
				.orElseThrow(() -> new AddressNotFoundException("Endereço de id: " + id + " não encontrado."));
		
		return new AddressDto(address);
	}

	@Override
	public Address save(AddressForm form) {
		
		if(form.getLongitude() == null || form.getLatitude() == null) {
			form = getCoordinates(form);
		}
		
		return this.addressRepository.save(form.convert());
	}
	
	private AddressForm getCoordinates(AddressForm form) {
		StringBuilder address = new StringBuilder();
		address.append(form.getNumber()+"+");
		address.append(form.getComplement() + "+");
		address.append(form.getStreetName()+"+");
		address.append(form.getNeighbourdhood() + "+");
		address.append(form.getCity()+"+");
		address.append(form.getState());
		try {
			GeocodingDto response = client.getGeocoding(address.toString(), geocodingKey);
			form.setLatitude(response.getResults().get(0).getGeometry().getLocation().getLatitude());
			form.setLongitude(response.getResults().get(0).getGeometry().getLocation().getLongitude());
		} catch (Exception e) {
			throw new GeocodingException("Erro ao realizar busca de coordenadas, favor informar latitude e longitude");
		}
		
		return form;
	}

	@Override
	public void delete(Long id) {
		Address address = this.addressRepository
				.findById(id)
				.orElseThrow(() -> new AddressNotFoundException("Erro ao deletar, endereço de id: " + id + " não encontrado."));
		this.addressRepository.delete(address);
	}

	@Override
	@Transactional
	public AddressDto update(Long id, AddressForm form) {
		Address address = this.addressRepository
				.findById(id)
				.orElseThrow(() -> new AddressNotFoundException("Erro ao atualizar, endereço de id: " + id + " não encontrado."));
		
		address.setStreetName(form.getStreetName());
		address.setNumber(form.getNumber());
		address.setComplement(form.getComplement());
		address.setNeighbourdhood(form.getNeighbourdhood());
		address.setCity(form.getCity());
		address.setState(form.getState());
		address.setCountry(form.getCountry());
		address.setZipcode(form.getZipcode());
		
		if(form.getLongitude() == null || form.getLatitude() == null) {
			form = getCoordinates(form);
		}
		
		address.setLatitude(form.getLatitude());
		address.setLongitude(form.getLongitude());
		
		return new AddressDto(address);
	}

}
