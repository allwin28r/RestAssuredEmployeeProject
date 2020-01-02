import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_Get_Request {

	@Test
	void getWeatherDetails()
	{
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification request=RestAssured.given();
		Response response=request.request(Method.GET,"/Chennai");
		
		String responsebody=response.getBody().asString();
		System.out.println("Response is = "+responsebody);
		
		int Statuscode=response.getStatusCode();
		Assert.assertEquals(Statuscode, 200);
		
		String statusLine=response.getStatusLine();
		System.out.println(statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		
	}
}
