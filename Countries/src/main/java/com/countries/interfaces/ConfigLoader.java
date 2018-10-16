package com.countries.interfaces;

import java.util.Properties;

public interface ConfigLoader {
	
	/**
	 * This method loads configurations from resources/config.properties and returns a Properties object
	 * @return Properties object containing configurations
	 * @throws RuntimeException If an error occur a RuntimeException must be thrown
	 */
	Properties loadConfig() throws RuntimeException;
}
