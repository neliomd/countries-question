package com.countries.interfaces;

import com.countries.dto.CountryInfo;

public interface CountryApi {
		
		public <T extends CountryInfo> T callAPI(String endpoint, Class<T> type) throws RuntimeException;
}
