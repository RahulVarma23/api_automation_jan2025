package gorestservicetests;

import base.BaseRequest;
import config.RequestPath;
import config.RequestSpec;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.models.GoRestUser;
import utils.RandomDataGenerator;

public class CreateUserTest extends BaseRequest {

    @Test
    public void testUserCreation() {
        RequestSpecification requestSpecification =  RequestSpec.goRestRequestSpec().basePath(RequestPath.USERS);

        GoRestUser goRestUser =  GoRestUser.builder()
                .name(RandomDataGenerator.getRandomStringValue(5))
                .gender("male")
                .email(RandomDataGenerator.getRandomEmailId(10))
                .status("active")
                .build();

        Response response = sendPostRequest(requestSpecification, goRestUser);

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED);
    }
}
