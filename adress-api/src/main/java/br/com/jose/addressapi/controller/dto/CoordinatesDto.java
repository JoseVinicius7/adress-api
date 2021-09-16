package br.com.jose.addressapi.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoordinatesDto {
	
	public CoordinatesDto(Double latitude, Double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public CoordinatesDto() {
		
	}
	
	@JsonProperty("lat")
	private Double latitude;
	
	@JsonProperty("lng")
	private Double longitude;

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "CoordinatesDto [latitude=" + latitude + ", longitude=" + longitude + "]";
	}

}
