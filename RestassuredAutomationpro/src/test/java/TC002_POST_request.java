import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_request {

	@Test
	void registerdata()
	{
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		RequestSpecification httprequest=RestAssured.given();
		JSONObject requestParams=new JSONObject();
		requestParams.put("FirstName", " aABCDFGAV");
		requestParams.put("LastName", " aGGHAV");
		requestParams.put("UserName", "aABCDFGABV");
		requestParams.put("Password", "aABCDFGvghhj");
		requestParams.put("Email", "AsBCDF@Gnn.com");
		
		httprequest.header("content-type","application/json");
		httprequest.body(requestParams.toJSONString());
		Response response=httprequest.request(Method.POST,"/register");
		
		String responsebody=response.getBody().asString();
		System.out.println("Response is = "+responsebody);
		
		int Statuscode=response.getStatusCode();
		Assert.assertEquals(Statuscode, 201);

		String successcode=response.jsonPath().get("SuccessCode");
		Assert.assertEquals(successcode, "OPERATION_SUCCESS");
		
		Headers header=response.headers();
		
		for(Header head:header)
		{
			System.out.println(head.getValue());
		}
			
		JsonPath jsonpath=response.jsonPath();
		System.out.println("JSON PATH = "+jsonpath.get("SuccessCode"));
		
	}
}
