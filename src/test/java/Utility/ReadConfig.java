package Utility;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    Properties properties;
	
	String path="C:\\Users\\HP\\3D Objects\\Project71\\src\\test\\resources\\config.properties";
	
	public ReadConfig() {
		try {
			properties=new Properties();
			
			//to open config.properties file in input mode and load the file
			FileInputStream file=new FileInputStream(path);
			properties.load(file);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getBrowser() {
		String value=properties.getProperty("browser");
		if(value!=null) {
			return value;
		}
		else {
			throw new RuntimeException("url not specified in config. file");
		}
	}
	
	public String getURL() {
		String value=properties.getProperty("url");
		if(value!=null) {
			return value;
		}
		else {
			throw new RuntimeException("url not specified in config. file");
		}
	}
	
	public String getDate() {
		String value=properties.getProperty("date");
		if(value!=null) {
			return value;
		}
		else {
			throw new RuntimeException("date not specified in config. file");
		}
	}
	
	public String getMonth() {
		String value=properties.getProperty("month");
		if(value!=null) {
			return value;
		}
		else {
			throw new RuntimeException("month not specified in config. file");
		}
	}
	
	
	public String getAdults() {
		String value=properties.getProperty("adult");
		if(value!=null) {
			return value;
		}
		else {
			throw new RuntimeException("adult not specified in config. file");
		}
	}
	
	public String getInfants() {
		String value=properties.getProperty("infant");
		if(value!=null) {
			return value;
		}
		else {
			throw new RuntimeException("infant not specified in config. file");
		}
	}
	
	public String getOrigin() {
		String value=properties.getProperty("origin");
		if(value!=null) {
			return value;
		}
		else {
			throw new RuntimeException("origin not specified in config. file");
		}
	}
	
	public String getDestination() {
		String value=properties.getProperty("destination");
		if(value!=null) {
			return value;
		}
		else {
			throw new RuntimeException("destination not specified in config. file");
		}
	}
	
	public String getmode1() {
		String value=properties.getProperty("mode1");
		if(value!=null) {
			return value;
		}
		else {
			throw new RuntimeException("mode1 not specified in config. file");
		}
	}
	
	public String getmode2() {
		String value=properties.getProperty("mode2");
		if(value!=null) {
			return value;
		}
		else {
			throw new RuntimeException("mode2 not specified in config. file");
		}
	}
	
	
	public String getmode3() {
		String value=properties.getProperty("mode3");
		if(value!=null) {
			return value;
		}
		else {
			throw new RuntimeException("mode3 not specified in config. file");
		}
	}
	
	public String getJ() {
		String value=properties.getProperty("j");
		if(value!=null) {
			return value;
		}
		else {
			throw new RuntimeException("j not specified in config. file");
		}
	}
	
	public String K() {
		String value=properties.getProperty("k");
		if(value!=null) {
			return value;
		}
		else {
			throw new RuntimeException("k not specified in config. file");
		}
	}
		
		public String GetProperty() {
			String value=properties.getProperty("execution_env");
			if(value!=null) {
				return value;
			}
			else {
				throw new RuntimeException("execution_env  not specified in config. file");
			}
		}

		public String GetOS() {
			String value=properties.getProperty("os");
			if(value!=null) {
				return value;
			}
			else {
				throw new RuntimeException("os not specified in config. file");
			}
		}
			
			
	}








}
