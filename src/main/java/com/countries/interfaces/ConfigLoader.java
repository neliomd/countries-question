package com.countries.interfaces;

import java.util.Properties;

public interface ConfigLoader {
	
	Properties loadConfig() throws RuntimeException;
}
