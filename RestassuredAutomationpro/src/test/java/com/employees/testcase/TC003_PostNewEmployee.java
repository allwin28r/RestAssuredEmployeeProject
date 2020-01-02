package com.employees.testcase;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employee.testbase.Testbase;
import com.employee.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC003_PostNewEmployee extends Testbase{

	String name=RestUtils.empName();
	String age=RestUtils.empAge();
	String salary=RestUtils.empSal();
	@BeforeClass
	void createEmp()
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httprequest=RestAssured.given();
		
		JSONObject requestParams=new JSONObject();
		requestParams.put("name", name);
		requestParams.put("age", age);
		requestParams.put("salary", salary);
		
		httprequest.header("content-type","application/json");
		
		httprequest.body(requestParams.toJSONString());
		response=httprequest.request(Method.POST,"/create");
		
		String responseBody=response.getBody().asString();
		
		logger.info("Response of employee created"+responseBody);
		
	}
	
	@Test
	void validateStatuscode()
	{
		int statcode=response.getStatusCode();
		Assert.assertEquals(statcode, 200);
		logger.info("Status code value"+statcode);

	}

}
