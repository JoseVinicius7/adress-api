package br.com.jose.addressapi.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.jose.addressapi.controller.dto.AddressDto;
import br.com.jose.addressapi.controller.form.AddressForm;
import br.com.jose.addressapi.entity.Address;
import br.com.jose.addressapi.service.AddressService;

@RestController
@RequestMapping("address")
public class AddressController {

	private AddressService addressService;

	public AddressController(AddressService addressService) {
		this.addressService = addressService;
	}
	
	@PostMapping
	public ResponseEntity<AddressDto> save(@RequestBody @Valid AddressForm form, UriComponentsBuilder uriBuilder) {
		
		Address address = this.addressService.save(form);
		
		URI uri = uriBuilder.path("/address/{id}")
				.buildAndExpand(address.getId()).toUri();

		return ResponseEntity.created(uri).body(new AddressDto(address));
	}
	
	@GetMapping
	public List<AddressDto> getAdresses(){
		
		return this.addressService.getAll();
	}
	
	@GetMapping("/{id}")
	public AddressDto getAddress(@PathVariable("id") Long id) {
		
		return this.addressService.getAddress(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAddress(@PathVariable("id") Long id){
		this.addressService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public AddressDto updateAddress(@PathVariable("id") Long id, @RequestBody AddressForm form){
		
		return this.addressService.update(id, form);
	}

}
