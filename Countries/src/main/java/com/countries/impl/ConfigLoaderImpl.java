package com.countries.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.countries.interfaces.ConfigLoader;

public class ConfigLoaderImpl implements ConfigLoader {

	@Override
	public Properties loadConfig() throws RuntimeException {
		Properties prop = new Properties();
    	InputStream input = null;
    	
    	try {
        
    		String filename = "config.properties";
    		input = ConfigLoaderImpl.class.getClassLoader().getResourceAsStream(filename);
    		if(input==null){
    		    throw new RuntimeException("Unable to load config");
    		}
    		prop.load(input);

 
    	} catch (Exception ex) {
    		throw new RuntimeException(ex);
        } finally{
        	if(input!=null){
        		try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        	}
        }
    	return prop;
    }
}
