package br.com.jose.addressapi.controller.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressComponentDto {
	
	@JsonProperty("long_name")
	private String longName;
	
	@JsonProperty("short_name")
	private String shortName;
	
	private List<String> types;

	public String getLongName() {
		return longName;
	}

	public void setLongName(String longName) {
		this.longName = longName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	@Override
	public String toString() {
		return "AddressComponentDto [longName=" + longName + ", shortName=" + shortName + ", types=" + types + "]";
	}
	
}
