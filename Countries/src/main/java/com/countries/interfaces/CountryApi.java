package com.countries.interfaces;

public interface CountryApi {
		
		/**
	     * This method loads properties configuration file and then calls the Countries API to get desired country data.
	     * @param <T> the type of the desired object CountryArea|CountryCode
	     * @param endpoint The Countries API endpoint to be called. Ex: /countries/US/area
	     * @param type The expected return type 
	     * @return an object of type T with the requested Country info
	     * @throws RuntimeException if API call fails a RuntimeException must be thrown
	     */
		public <T> T callAPI(String endpoint, Class<T> type) throws RuntimeException;
}
