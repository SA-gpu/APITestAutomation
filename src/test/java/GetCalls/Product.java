package GetCalls;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Product {

	@Test
	public static void PriceSort() {
        RestAssured.baseURI = "http://localhost:3030";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
       
        Reporter.log("Product get Request send");
        Response response = httpRequest.get("/products?$sort[price]=-1");
        Reporter.log("Product get Response");
        System.out.println("Response JSON :" + response.getBody().asString());
        String sat= response.getStatusLine();
        Assert.assertEquals(sat, "HTTP/1.1 200 OK");
        System.out.println("Status: "+sat);
	}
		
	@Test
	public static void NameDesc() {
        RestAssured.baseURI = "http://localhost:3030";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
       
        Reporter.log("Name & Desc get Request send");
        Response response = httpRequest.get("/products?$select[]=name&$select[]=description");
        Reporter.log("Name & Desc get Response");
        System.out.println("Response JSON :" + response.getBody().asString());
        String sat= response.getStatusLine();
        Assert.assertEquals(sat, "HTTP/1.1 200 OK");
        System.out.println("Status: "+sat);
	}
	
	@Test
	public static void FreeShippingPricebetween() {
        RestAssured.baseURI = "http://localhost:3030";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
       
        Reporter.log("Name & Desc get Request send");
        Response response = httpRequest.get("/products?category.name=TVs&price[$gt]=500&price[$lt]=800&shipping[$eq]=0");
        Reporter.log("Name & Desc get Response");
        System.out.println("Response JSON :" + response.getBody().asString());
        String sat= response.getStatusLine();
        Assert.assertEquals(sat, "HTTP/1.1 200 OK");
        System.out.println("Status: "+sat);
	}
}
