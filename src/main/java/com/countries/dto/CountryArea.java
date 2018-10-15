package com.countries.dto;

public class CountryArea extends CountryInfo {
	private static final long serialVersionUID = 1L;
	
	private String iso3166alpha2;
	private Float area;
	
	
	public CountryArea(String iso3166alpha2, Float area) {
		super();
		this.iso3166alpha2 = iso3166alpha2;
		this.area = area;
	}
	
	public String getIso3166alpha2() {
		return iso3166alpha2;
	}
	public void setIso3166alpha2(String iso3166alpha2) {
		this.iso3166alpha2 = iso3166alpha2;
	}

	public Float getArea() {
		return area;
	}

	public void setArea(Float area) {
		this.area = area;
	}
	
}
