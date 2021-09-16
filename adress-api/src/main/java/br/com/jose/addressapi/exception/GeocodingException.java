package br.com.jose.addressapi.exception;

public class GeocodingException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public GeocodingException(String message) {
		super(message);
	}

}
