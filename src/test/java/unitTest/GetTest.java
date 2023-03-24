package unitTest;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetTest {
	
	@Test(enabled = false)
	public void getUsersPretty() {
		RestAssured.get("http://localhost:3000/users").prettyPrint();
	}
	
	@Test(enabled = false)
	public void getUsersVar() {
		Response response =RestAssured.get("http://localhost:3000/users");
		System.out.println(response.asString());
	}
	
	@Test(enabled = false)
	public void getUsersResponseCodeValidation() {
	     RestAssured.get("http://localhost:3000/users/5")
	     .then()
	     .statusCode(200);
	 
	}
	
	@Test(enabled = false)
	public void getUsersResponseCodeValidationNegativeTest404() {
	     RestAssured.get("http://localhost:3000/users/10")
	     .then()
	     .statusCode(404);
	}
	
	@Test(enabled = false)
	public void getUsersLogs() {
		RestAssured.given()
		.log().all()
		.get("http://localhost:3000/users/3")
		.then()
		.log().all()
		.statusCode(200);
	}
	
	@Test(enabled =true )
	public void getUserResponseValidation() {
		RestAssured.given()
		.log().all()
		.get("http://localhost:3000/users/3")
		.then()
		.log().all()
		.statusCode(200)
		.and()
		.body("id",equalTo(3))
		.body("firstname", equalTo("Rakhi"))
		.body("height", equalTo("5.3"))
		.body("age", equalTo("26"));
		
	}
	

}
