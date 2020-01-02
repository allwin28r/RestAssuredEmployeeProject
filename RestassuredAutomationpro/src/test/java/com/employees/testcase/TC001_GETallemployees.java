package com.employees.testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employee.testbase.Testbase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC001_GETallemployees extends Testbase {

	@BeforeClass
	void getallEmployees()
	{
		logger.info("GET ALL EMPLOYEES");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httprequest=RestAssured.given();
		response=httprequest.request(Method.GET,"/employees");
		String responseBody=response.getBody().asString();
		logger.info("Response Data ****/n"+responseBody);

		System.out.println("REsponse = "+responseBody);
	}
	
	@Test
	void checkStatusCode()
	{
		int statusCode=response.getStatusCode();
		logger.info("Status code ****/n"+statusCode);

		Assert.assertEquals(statusCode, 200);
	}
	@Test
	void checkResponseBody()
	{
		String responseBody=response.getBody().asString();
		Assert.assertTrue(responseBody!=null);
	}
}
