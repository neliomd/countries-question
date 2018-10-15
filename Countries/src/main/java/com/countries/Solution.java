package com.countries;

import com.countries.dto.CountryArea;
import com.countries.dto.CountryCode;
import com.countries.impl.CountryApiImpl;

public class Solution {
	
	public static void main(String[] args) {
		
		CountryApiImpl countryAPIImpl = new CountryApiImpl();
		CountryCode countryCode = countryAPIImpl.callAPI("/countries/Colombia/iso3166", CountryCode.class);
		CountryArea countryArea = countryAPIImpl.callAPI("/countries/"+countryCode.getIso3166alpha2()+"/area", CountryArea.class);
		System.out.println(countryCode.getIso3166alpha2());
		System.out.println(countryArea.getArea());
	}
}
