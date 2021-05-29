package Config_Reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import Enum.BrowserType;
import Enum.EnvironmentType;

public class ConfigFile_Reader
{
	private Properties properties;
	private final String propertyFilePath= "//src//test//resources//Config//config.properties";

	
	public ConfigFile_Reader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(System.getProperty("user.dir")+propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	public String getDriverPath(){
		String driverPath = properties.getProperty("driverPath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
	}
	
	public long getImplicitlyWait() {		
		String implicitlyWait = properties.getProperty("implicitwait");
		if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
		else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");		
	}
	
	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	public BrowserType getBrowser() {
		String browserName = properties.getProperty("browser");
		if(browserName == null || browserName.equals("chrome")) return BrowserType.CHROME;
		else if(browserName.equalsIgnoreCase("firefox")) return BrowserType.FIREFOX;
		else if(browserName.equals("ie")) return BrowserType.INTERNETEXPLORER;
		else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}

	public EnvironmentType getEnvironment() {
		String environmentName = properties.getProperty("environment");
		if(environmentName == null || environmentName.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
		else if(environmentName.equals("remote")) return EnvironmentType.REMOTE;
		else throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentName);
	}

	public Boolean getBrowserWindowSize() {
		String windowSize = properties.getProperty("windowMaximize");
		if(windowSize != null) return Boolean.valueOf(windowSize);
		return true;
	}
	public String getReportConfigPath(){
		String reportConfigPath = properties.getProperty("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}


}
