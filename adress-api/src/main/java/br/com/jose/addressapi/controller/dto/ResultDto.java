package br.com.jose.addressapi.controller.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultDto {
	
	@JsonProperty("address_components")
	private List<AddressComponentDto> addressComponents = new ArrayList<>();
	
	@JsonProperty("formatted_address")
	private String formattedAddress;
	
	private GeometryDto geometry;
	
	@JsonProperty("place_id")
	private String placeId;
	
	@JsonProperty("plus_code")
	private plusCodeDto plusCode;
	
	private List<String> types = new ArrayList<>();

	public List<AddressComponentDto> getAddressComponents() {
		return addressComponents;
	}

	public void setAddressComponents(List<AddressComponentDto> addressComponents) {
		this.addressComponents = addressComponents;
	}

	public String getFormattedAddress() {
		return formattedAddress;
	}

	public void setFormattedAddress(String formattedAddress) {
		this.formattedAddress = formattedAddress;
	}

	public GeometryDto getGeometry() {
		return geometry;
	}

	public void setGeometry(GeometryDto geometry) {
		this.geometry = geometry;
	}

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	public plusCodeDto getPlusCode() {
		return plusCode;
	}

	public void setPlusCode(plusCodeDto plusCode) {
		this.plusCode = plusCode;
	}

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}
	
	@Override
	public String toString() {
		return "ResultDto [addressComponents=" + addressComponents + ", formattedAddress=" + formattedAddress
				+ ", geometry=" + geometry + ", placeId=" + placeId + ", plusCode=" + plusCode + ", types=" + types
				+ "]";
	}

}
