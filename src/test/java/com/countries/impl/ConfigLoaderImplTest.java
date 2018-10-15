package com.countries.impl;

import static org.junit.Assert.assertTrue;

import java.util.Properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class ConfigLoaderImplTest 
{
	ConfigLoaderImpl configLoader = new ConfigLoaderImpl();
	
	@Test
	public void testLoadConfig() {
		Properties props = configLoader.loadConfig();
		assertTrue("api".equals(props.get("api.user")) && 
				"EwqGSbZ3Gh".equals(props.get("api.password")) &&
				"https://api-dev-01.emcconnected.com".equals(props.get("api.url")));
	}
}
