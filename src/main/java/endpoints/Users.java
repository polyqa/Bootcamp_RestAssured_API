package endpoints;

import utils.RestSpacifications;

public class Users extends RestSpacifications {
	private final String ENDPOINT = "/users";

	public void getUsers() {
		getCall(ENDPOINT);
	}

}
