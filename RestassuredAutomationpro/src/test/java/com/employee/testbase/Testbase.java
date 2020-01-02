package com.employee.testbase;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Testbase {
	public static RequestSpecification httprequest;
	public static Response response;
	public Logger logger;
	public String empid="253";
	
	@BeforeClass
	public void setup()
	{
		logger=Logger.getLogger("EployeeREstAPI");
		PropertyConfigurator.configure("Log4j.properties");
		logger.setLevel(Level.DEBUG);
		
		
	}
}
