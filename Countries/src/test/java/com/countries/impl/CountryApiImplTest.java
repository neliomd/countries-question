package com.countries.impl;

import static org.junit.Assert.assertTrue;

import java.net.URLEncoder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;

import com.countries.dto.CountryArea;
import com.countries.dto.CountryCode;

@PowerMockIgnore({"javax.net.ssl.*"})
@RunWith(PowerMockRunner.class)
public class CountryApiImplTest {

	CountryApiImpl countryApi = new CountryApiImpl();
	
	@Test
	public void testSpainCode()  throws Exception {
		CountryCode code = countryApi.callAPI("/countries/Spain/iso3166", CountryCode.class);
		assertTrue("ES".equals(code.getIso3166alpha2()));
	}
	
	@Test
	public void testUSACode() throws Exception {
		CountryCode code = countryApi.callAPI("/countries/" + URLEncoder.encode("United States of America", "UTF-8").replace("+", "%20") + "/iso3166", CountryCode.class);
		assertTrue("US".equals(code.getIso3166alpha2()));
	}
	
	@Test
	public void testCanadaCode() throws Exception {
		CountryCode code = countryApi.callAPI("/countries/Canada/iso3166", CountryCode.class);
		assertTrue("CA".equals(code.getIso3166alpha2()));
	}
	
	@Test
	public void testRussiaArea() throws Exception {
		CountryArea area = countryApi.callAPI("/countries/RU/area", CountryArea.class);
		assertTrue(area.getArea()==17098246f);
	}
	
	@Test
	public void testChinaArea() throws Exception {
		CountryArea area = countryApi.callAPI("/countries/CN/area", CountryArea.class);
		assertTrue(area.getArea()==9572900f);
	}
	
	@Test
	public void testMonacoArea() throws Exception {
		CountryArea area = countryApi.callAPI("/countries/MC/area", CountryArea.class);
		assertTrue(area.getArea()==1.95f);
	}
}
