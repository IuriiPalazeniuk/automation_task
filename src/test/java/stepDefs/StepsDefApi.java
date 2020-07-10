package stepDefs;

import api.usersApi.RestApiUsers;
import api.usersApi.request.UsersRequest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static api.ScenarioContext.ContextEnum.HTTP_RESPONSE_STATUS_CODE;
import static org.junit.Assert.assertEquals;

public class StepsDefApi {

    private RestApiUsers apiUsers = new RestApiUsers();

    @Given("create new user with {string} name and {string} job position")
    public void createNewUser(String userName, String jobPosition) {
        UsersRequest user = new UsersRequest(userName, jobPosition);
        apiUsers.postNewUserRequest(user);
    }

    @Then("check status code {int}")
    public void checkStatusCode(int statusCode) {
        int code = api.ScenarioContext.getContext(HTTP_RESPONSE_STATUS_CODE);
        assertEquals(String.format("User wasn't created, status code: %s", code), code, statusCode);
    }

    @Given("get created user by {int} id")
    public void getCreatedUserById(int userId) {
        apiUsers.getCreatedUserById(userId);
    }

    @Given("update created user by {int} id with {string} name and {string} job")
    public void updateCreatedUserById(int userId, String userName, String jobPosition) {
        UsersRequest user = new UsersRequest(userName, jobPosition);
        apiUsers.updateCreatedUserById(userId, user);
    }

    @Given("delete created user by {int}")
    public void deleteCreatedUserBy(int userId) {
        apiUsers.deleteCreatedUserById(userId);
    }


}
