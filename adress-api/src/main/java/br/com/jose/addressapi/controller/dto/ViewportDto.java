package br.com.jose.addressapi.controller.dto;

public class ViewportDto {
	
	private CoordinatesDto northeast;
	private CoordinatesDto southwest;

	public CoordinatesDto getNortheast() {
		return northeast;
	}

	public void setNortheast(CoordinatesDto northeast) {
		this.northeast = northeast;
	}

	public CoordinatesDto getSouthwest() {
		return southwest;
	}

	public void setSouthwest(CoordinatesDto southwest) {
		this.southwest = southwest;
	}

	@Override
	public String toString() {
		return "ViewportDto [northeast=" + northeast + ", southwest=" + southwest + "]";
	}

}
