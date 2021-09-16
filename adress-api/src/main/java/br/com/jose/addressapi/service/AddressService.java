package br.com.jose.addressapi.service;

import java.util.List;

import br.com.jose.addressapi.controller.dto.AddressDto;
import br.com.jose.addressapi.controller.form.AddressForm;
import br.com.jose.addressapi.entity.Address;

public interface AddressService {
	
	List<AddressDto> getAll();
	AddressDto getAddress(Long id);
	Address save(AddressForm form);
	void delete(Long id);
	AddressDto update(Long id, AddressForm form);

}
