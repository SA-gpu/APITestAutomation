package Create;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class NewEntry {
	public static String price = RandomStringUtils.randomNumeric(3);
	public static Integer result = Integer.valueOf(price);	
	public static String upc = RandomStringUtils.randomNumeric(8);
	public static String mod = RandomStringUtils.randomAlphabetic(4);
	public static String el = RandomStringUtils.randomNumeric(4);
	
	
	@Test
	public static void Product() {
        RestAssured.baseURI = "http://localhost:3030";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");

        // Create new JSON Object
        JsonObject Credentials = new JsonObject();
        Credentials.addProperty("name", "New Product");
        Credentials.addProperty("type", "Hard Good");
        Credentials.addProperty("upc",upc);
        Credentials.addProperty("price", result);
        Credentials.addProperty("description", "This is a placeholder request for creating a new product.");
        Credentials.addProperty("model",mod+el);
        httpRequest.body(Credentials.toString());
        Reporter.log("Create New Product Request");
        System.out.println("Body: "+ Credentials.toString());
        Response response = httpRequest.post("/products");
        Reporter.log("Create New Product Response");
        System.out.println("Response JSON :" + response.getBody().asString());
        String sat= response.getStatusLine();
        Assert.assertEquals(sat, "HTTP/1.1 201 Created");
        System.out.println("Status: "+sat);
	}
	@Test
	public static void Category() {
        RestAssured.baseURI = "http://localhost:3030";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
        
        // Create new JSON Object
        JsonObject Credentials = new JsonObject();
        Credentials.addProperty("id", mod+el);
        Credentials.addProperty("name", "New Category");
        httpRequest.body(Credentials.toString());
        System.out.println("Body: "+ Credentials.toString());
        Reporter.log("Create New Category Request");
        Response response = httpRequest.post("/categories");
        Reporter.log("Create New Category Response");
        System.out.println("Response JSON :" + response.getBody().asString());
        String sat= response.getStatusLine();
        Assert.assertEquals(sat, "HTTP/1.1 201 Created");
        System.out.println("Status: "+sat);
	}
	@Test
	public static void Service() {
        RestAssured.baseURI = "http://localhost:3030";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
       
        // Create new JSON Object
        JsonObject Credentials = new JsonObject();
        Credentials.addProperty("name", "Serv"+el);
        httpRequest.body(Credentials.toString());
        System.out.println("Body: "+ Credentials.toString());
        Reporter.log("Create New Service Request");
        Response response = httpRequest.post("/services");
        Reporter.log("Create New Service Response");
        System.out.println("Response JSON :" + response.getBody().asString());
        String sat= response.getStatusLine();
        Assert.assertEquals(sat, "HTTP/1.1 201 Created");
        System.out.println("Status: "+sat);
	}
	@Test
	public static void Store() {
        RestAssured.baseURI = "http://localhost:3030";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
       
        // Create new JSON Object
        JsonObject Credentials = new JsonObject();
        Credentials.addProperty("name", "New Store");
        Credentials.addProperty("type", "BigBox");
        Credentials.addProperty("address", price+" Fake St");
        Credentials.addProperty("address2", "");
        Credentials.addProperty("city", "Springfield");
        Credentials.addProperty("state", mod.toUpperCase());
        Credentials.addProperty("zip", el+1);
        Credentials.addProperty("lat", 44.969658);
        Credentials.addProperty("lng",-93.449539);
        Credentials.addProperty("hours", "Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8");
        httpRequest.body(Credentials.toString());
        System.out.println("Body: "+ Credentials.toString());
        Reporter.log("Create New Store Request");
        Response response = httpRequest.post("/stores");
        Reporter.log("Create New Store Response");
        System.out.println("Response JSON :" + response.getBody().asString());
        String sat= response.getStatusLine();
        Assert.assertEquals(sat, "HTTP/1.1 201 Created");
        System.out.println("Status: "+sat);
        
	}
		
	
}