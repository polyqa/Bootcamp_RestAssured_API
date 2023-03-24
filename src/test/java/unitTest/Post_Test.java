package unitTest;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import groovy.lang.Newify;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Post_Test {
	@Test(enabled = false)
	public void postTestStringBody() {
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.contentType(ContentType.JSON)
		.body("{\"id\": 7,   \"firstname\": \"Ruksana\",    \"lastname\": \"Parvin\",  \"height\": \"5.4\",    \"age\": \"30\"}")
		.basePath("/users")
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(201);
		
		
	}
	
	@Test(enabled = true)
	public void postTestStringBody400() {
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.contentType(ContentType.JSON)
		.body("{\"id\": 7,   \"firstname\": \"Ruksana\",    \"lastname\": \"Parvin\",  \"height\": \"5.4\",    \"age\": \"30\"}")
		.basePath("/users")
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(400);
		
		
	}
	
	@Test(enabled = false)
	public void postTestFileBody500() {
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.contentType(ContentType.JSON)
		.body(new File("src/test/resources/users.json"))
		.basePath("/users")
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(500);
		
		
	}
	
	@Test(enabled = false)
	public void postTestInputStreamBody() {
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.contentType(ContentType.JSON)
		.body(getClass().getClassLoader().getResourceAsStream("users3.json"))
		.basePath("/users")
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(201);
		
		
	}
	
	@Test(enabled = false)
	public void postTestByteBody() {
		try {
			RestAssured.given()
			.baseUri("http://localhost:3000")
			.contentType(ContentType.JSON)
			.body(getClass().getClassLoader().getResourceAsStream("users3.json").readAllBytes())
			.basePath("/users")
			.when()
			.log().all()
			.post()
			.then()
			.log().all()
			.statusCode(201);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Test(enabled = false)
	public void postTestMapBody() {
		Map<String, Object> map = new HashMap<>();
		map.put("firstName", "Tania");
		map.put("lastName", "Sarker");
		map.put("height", "5.2");
		map.put("age", 29);
		
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.contentType(ContentType.JSON)
		.body(map)
		.basePath("/users")
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(201);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
