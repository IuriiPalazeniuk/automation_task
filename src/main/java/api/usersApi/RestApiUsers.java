package api.usersApi;

import api.RestAssuredHelper;
import api.usersApi.request.UsersRequest;
import api.usersApi.response.SingleUserResponse;
import api.usersApi.response.UpdateUserResponse;
import api.usersApi.response.UserPostResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import static helpers.PropertiesFileReader.getSystemPropertyByName;

@Slf4j
public class RestApiUsers extends RestAssuredHelper {
    private final String endPoint = getSystemPropertyByName("endPoint");
    private api.ScenarioContext scenarioContext = new api.ScenarioContext();

    @SneakyThrows
    public void postNewUserRequest(UsersRequest model) {
        Response rawResponse = postRequest(obtainRequestSpec(), endPoint, model);
        saveResponseToContext(scenarioContext, rawResponse, UserPostResponse.class);
    }

    @SneakyThrows
    public void getCreatedUserById(int id) {
        Response rawResponse = getRequest(obtainRequestSpec(), endPoint + "/", String.valueOf(id));
        saveResponseToContext(scenarioContext, rawResponse, SingleUserResponse.class);
    }

    @SneakyThrows
    public void updateCreatedUserById(int id, UsersRequest model) {
        Response rawResponse = putRequest(obtainRequestSpec(), endPoint + "/", String.valueOf(id), model);
        saveResponseToContext(scenarioContext, rawResponse, UpdateUserResponse.class);
    }

    @SneakyThrows
    public void deleteCreatedUserById(int id) {
        Response rawResponse = deleteRequest(obtainRequestSpec(), endPoint + "/", String.valueOf(id));
        saveResponseToContext(scenarioContext, rawResponse, null);
    }

    private RequestSpecification obtainRequestSpec() {
        log.info("Request specification is obtained");
        return setupRequestSpecification(getSystemPropertyByName("API_Url"));
    }
}
