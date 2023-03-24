package functionalTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import endpoints.Ages;

public class PostAgesTest {
	Ages ages;

	@BeforeMethod
	public void init() {
		ages = new Ages();
		ages.init();
	}

	@Test
	public void postAAge() {
		ages.postAAge();
		ages.validateStatusCode(201);
		ages.validatePayloadObject("gender", "Female");
		ages.validate_w_JsonPath("age", 90);
	}

}
