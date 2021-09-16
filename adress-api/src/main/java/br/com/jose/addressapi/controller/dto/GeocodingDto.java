package br.com.jose.addressapi.controller.dto;

import java.util.ArrayList;
import java.util.List;

public class GeocodingDto {

	private List<ResultDto> results = new ArrayList<>();
	private String status;

	public List<ResultDto> getResults() {
		return results;
	}

	public void setResults(List<ResultDto> results) {
		this.results = results;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "GeocodingDto [results=" + results + ", status=" + status + "]";
	}

}
