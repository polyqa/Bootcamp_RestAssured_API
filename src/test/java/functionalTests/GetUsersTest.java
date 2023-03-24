package functionalTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import endpoints.Users;

public class GetUsersTest {

	Users users;

	@BeforeMethod
	public void initTests() {
		users = new Users();
		users.init();
	}

	@Test
	public void getUsersValidation() {
		users.getUsers();
		users.validateStatusCode(200);
	}

}
