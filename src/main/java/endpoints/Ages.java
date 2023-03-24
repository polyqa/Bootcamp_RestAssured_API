package endpoints;

import utils.RestSpacifications;

public class Ages extends RestSpacifications {
	private final String ENDPOINT = "/ages";
	private final String fileName = "ages.json";

	public void getAges() {
		getCall(ENDPOINT);
	}

	public void getEachAge(int age) {
		getCall(ENDPOINT + "/" + age);
	}

	public void postAAge() {
		setBody(getClass().getClassLoader().getResourceAsStream(fileName));
		setContentTypeAsJson();
		setBasicAuth("user", "pass");
		postCall(ENDPOINT);
	}

}
