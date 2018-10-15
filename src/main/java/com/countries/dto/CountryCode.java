package com.countries.dto;

public class CountryCode extends CountryInfo {
	private static final long serialVersionUID = 1L;
	
	private String iso3166alpha2;
	private String name;
	
	
	public CountryCode(String iso3166alpha2, String name) {
		super();
		this.iso3166alpha2 = iso3166alpha2;
		this.name = name;
	}
	
	public String getIso3166alpha2() {
		return iso3166alpha2;
	}
	public void setIso3166alpha2(String iso3166alpha2) {
		this.iso3166alpha2 = iso3166alpha2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
