package br.com.jose.addressapi.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.jose.addressapi.controller.dto.GeocodingDto;

@FeignClient(name = "geocoding", url = "${geocoding.url}")
public interface GeocodingClient {
	
	@GetMapping
	public GeocodingDto getGeocoding(@RequestParam String address, @RequestParam String key);
	
}
