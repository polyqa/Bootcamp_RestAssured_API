package unitTest;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutTest {
	
	@Test
	public void putTest() {
		Map<String, Object> map = new HashMap<>();
		map.put("firstName", "Moon");
		map.put("lastName", "Paul");
		map.put("height", "5.2");
		map.put("age", 28);
		
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.basePath("/users/7") 
		.contentType(ContentType.JSON)
		.body(map)
		.log().all()
		.put()
		.then()
		.log().all()
		.statusCode(200);
	}

}
