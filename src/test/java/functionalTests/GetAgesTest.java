package functionalTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import endpoints.Ages;

public class GetAgesTest {

	Ages ages;

	@BeforeMethod
	public void init() {
		ages = new Ages();
		ages.init();
	}

	@Test(enabled = true)
	public void getAges() {
		ages.getAges();
		ages.validateStatusCode(200);
	}

	@Test(enabled = false)
	public void getAgeById() {
		ages.getEachAge(4);
		ages.validateStatusCode(200);
		ages.validatePayloadObject("gender", "Male");
		ages.validatePayloadObject("age", 30);
		ages.validate_w_JsonPath("id", 4);
	}

	@Test(enabled = false)
	public void responValidation() {
		ages.getEachAge(30);
		System.out.println(ages.getResponse().getBody().jsonPath().getString("gender"));
	}

}
