package datacheckpoi;

import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class DatacheckPoi {

	@Test(dataProvider="empdata")
	void postNewEmployees(String ename,String eage,String esal)
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RequestSpecification httprequest=RestAssured.given();
		JSONObject requestParams=new JSONObject();
		requestParams.put("name", ename);
		requestParams.put("salary", eage);
		requestParams.put("age", esal);
		
		httprequest.header("content-type","application/json");
		httprequest.body(requestParams.toJSONString());
		
		Response response=httprequest.request(Method.POST,"/create");
		String body=response.getBody().asString();
		
		System.out.println("Body is "+body);
		
		int statuscode=response.getStatusCode();
		
		Assert.assertEquals(statuscode, 200);
		long time=response.getTime();
		System.out.println(" Post Time ="+time);
		
		
	}
	@Test
	void getNewEmployees()
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RequestSpecification httprequest=RestAssured.given();
		JSONObject requestParams=new JSONObject();
		requestParams.put("name", "ABCXLKAB");
		requestParams.put("salary", "50000");
		requestParams.put("age", "30");
		
		httprequest.header("content-type","application/json");
		//httprequest.body(requestParams.toJSONString());
		
		Response response=httprequest.request(Method.GET,"/employees");
		String body=response.getBody().asString();
		
		System.out.println("Body is "+body);
		
		int statuscode=response.getStatusCode();
		long time=response.getTime();
		long stime=response.getTimeIn(TimeUnit.NANOSECONDS);

		System.out.println(" GET Time ="+time);
		System.out.println(" Unit Time ="+stime);

		
		
		Assert.assertEquals(statuscode, 200);				
	}
	
	@DataProvider(name="empdata") 
	String[][] getEmpData()
	{
		String[][] empData={{"ABCX","4500","45"},{"ABCXD","4500","45"},{"ABCXE","4500","45"}};
		return(empData);
	}
}
