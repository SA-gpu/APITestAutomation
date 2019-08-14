package GetCalls;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Store {

	@Test
	public static void StoreinState() {
        RestAssured.baseURI = "http://localhost:3030";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
       
        Reporter.log("Product get Request send");
        Response response = httpRequest.get("/stores?state=MN");
        Reporter.log("Product get Response");
        System.out.println("Response JSON :" + response.getBody().asString());
        String sat= response.getStatusLine();
        Assert.assertEquals(sat, "HTTP/1.1 200 OK");
        System.out.println("Status: "+sat);
	}
		
	@Test
	public static void ServiceName() {
        RestAssured.baseURI = "http://localhost:3030";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
       
        Reporter.log("Name & Desc get Request send");
        Response response = httpRequest.get("stores?service.name=Apple Shop");
        Reporter.log("Name & Desc get Response");
        System.out.println("Response JSON :" + response.getBody().asString());
        String sat= response.getStatusLine();
        Assert.assertEquals(sat, "HTTP/1.1 200 OK");
        System.out.println("Status: "+sat);
	}
	
	@Test
	public static void NearServiceStore() {
        RestAssured.baseURI = "http://localhost:3030";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
       
        Reporter.log("Name & Desc get Request send");
        Response response = httpRequest.get("/stores?near=90210&service.name=Windows%20Store");
        Reporter.log("Name & Desc get Response");
        System.out.println("Response JSON :" + response.getBody().asString());
        String sat= response.getStatusLine();
        Assert.assertEquals(sat, "HTTP/1.1 200 OK");
        System.out.println("Status: "+sat);
	}
}
