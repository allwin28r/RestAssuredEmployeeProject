package com.employees.testcase;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employee.testbase.Testbase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC002_GETspecificemployee extends Testbase{

	@BeforeClass
	void getuserempidData()
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httprequest=RestAssured.given();
		response=httprequest.request(Method.GET,"/employee/"+empid);
		String responseBody=response.getBody().asString();
		
			logger.info("Specific emp data /n"+responseBody);		
	}
	@Test
	void validateEmpid()
	{
		String responseBody=response.getBody().asString();

		Assert.assertEquals(responseBody.contains(empid), true);
	}
	@Test
	void validateStatuscode()
	{
		Assert.assertEquals(response.getStatusCode(),200);
	}
	
	@AfterClass
	void endCase()
	{
		logger.info("TC 002 is executed");		

	}
}
