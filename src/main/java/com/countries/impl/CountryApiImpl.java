package com.countries.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Properties;

import javax.net.ssl.HttpsURLConnection;

import com.countries.dto.CountryInfo;
import com.countries.interfaces.CountryApi;
import com.google.gson.Gson;

public class CountryApiImpl implements CountryApi {

	@Override
	public <T extends CountryInfo> T callAPI(String endpoint, Class<T> type) throws RuntimeException {
		try {
			ConfigLoaderImpl configLoaderImpl = new ConfigLoaderImpl();
			Properties properties = configLoaderImpl.loadConfig();
			URL url = new URL(properties.get("api.url")+endpoint);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			String encoded = Base64.getEncoder().encodeToString((properties.get("api.user")+":"+properties.get("api.password")).getBytes(StandardCharsets.UTF_8));  
			conn.setRequestProperty("Authorization", "Basic "+encoded);
			
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			try(BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())))) {

				String line, json = "";
				while ((line = br.readLine()) != null) {
					json += line;
				}
				Gson gson = new Gson();
				CountryInfo countryInfo = (CountryInfo)gson.fromJson(json, type);
				conn.disconnect();
				return type.cast(countryInfo);
			}

		  } catch (Exception e) {
			  throw new RuntimeException(e);
		  }
	}

}
