package br.com.jose.addressapi.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.jose.addressapi.entity.Address;

public class AddressForm {
	
	@NotBlank
	private String streetName;
	
	@NotNull
	private Integer number;
	
	@NotBlank
	private String complement;
	
	@NotBlank
	private String neighbourdhood;
	
	@NotBlank
	private String city;
	
	@NotBlank
	private String state;
	
	@NotBlank
	private String country;
	
	@NotNull
	private Integer zipcode;
	
	private Double latitude;
	private Double longitude;

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getNeighbourdhood() {
		return neighbourdhood;
	}

	public void setNeighbourdhood(String neighbourdhood) {
		this.neighbourdhood = neighbourdhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getZipcode() {
		return zipcode;
	}

	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}

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
	
	public Address convert() {
		Address address = new Address();
		address.setStreetName(this.streetName);
		address.setNumber(this.number);
		address.setComplement(this.complement);
		address.setNeighbourdhood(this.neighbourdhood);
		address.setCity(this.city);
		address.setState(this.state);
		address.setCountry(this.country);
		address.setZipcode(this.zipcode);
		address.setLatitude(this.latitude);
		address.setLongitude(this.longitude);
		
		return address;
	}

}
