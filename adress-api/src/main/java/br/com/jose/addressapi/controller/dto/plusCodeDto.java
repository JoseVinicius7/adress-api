package br.com.jose.addressapi.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class plusCodeDto {
	
	@JsonProperty("compound_code")
	private String compoundCode;
	
	@JsonProperty("global_code")
	private String globalCode;

	public String getCompoundCode() {
		return compoundCode;
	}

	public void setCompoundCode(String compoundCode) {
		this.compoundCode = compoundCode;
	}

	public String getGlobalCode() {
		return globalCode;
	}

	public void setGlobalCode(String globalCode) {
		this.globalCode = globalCode;
	}

	@Override
	public String toString() {
		return "plusCodeDto [compoundCode=" + compoundCode + ", globalCode=" + globalCode + "]";
	}

}
