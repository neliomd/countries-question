package com.countries;

import com.countries.dto.CountryArea;
import com.countries.dto.CountryCode;
import com.countries.impl.CountryApiImpl;

public class Solution {
	
	/*
	 * Compares two countries and and shows the bigger in km2 
	 */
	public static void main(String[] args) {
		String countryA = "China", countryB = "Russia";
		
		CountryApiImpl countryAPIImpl = new CountryApiImpl();
		CountryCode countryACode = countryAPIImpl.callAPI("/countries/"+countryA+"/iso3166", CountryCode.class);
		CountryCode countryBCode = countryAPIImpl.callAPI("/countries/"+countryB+"/iso3166", CountryCode.class);
		CountryArea countryAArea = countryAPIImpl.callAPI("/countries/"+countryACode.getIso3166alpha2()+"/area", CountryArea.class);
		CountryArea countryBArea = countryAPIImpl.callAPI("/countries/"+countryBCode.getIso3166alpha2()+"/area", CountryArea.class);
		
		if(countryBArea.getArea()>countryAArea.getArea())
			System.out.println(String.format("%s(%.2fkm2) is bigger than %s(%.2fkm2)", countryB, countryBArea.getArea(), countryA, countryAArea.getArea()));
		else
			System.out.println(String.format("%s(%.2fkm2) is bigger than %s(%.2fkm2)", countryA, countryAArea.getArea(), countryB, countryBArea.getArea()));
	}
}
