package br.com.jose.addressapi.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeometryDto {
	
	private CoordinatesDto location;
	
	@JsonProperty("location_type")
	private String locationType;
	
	private ViewportDto viewport;

	public CoordinatesDto getLocation() {
		return location;
	}

	public void setLocation(CoordinatesDto location) {
		this.location = location;
	}

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	public ViewportDto getViewport() {
		return viewport;
	}

	public void setViewport(ViewportDto viewport) {
		this.viewport = viewport;
	}

	@Override
	public String toString() {
		return "GeometryDto [location=" + location + ", locationType=" + locationType + ", viewport=" + viewport + "]";
	}

}
