package userservicetests;

import base.BaseRequest;
import config.RequestSpec;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.models.User;
import static config.RequestPath.USERS;
import static config.RequestPath.USERS_ID;
import static utils.RandomDataGenerator.getRandomStringValue;

public class PostUserTest extends BaseRequest {

    @Test
    public void testEmployeePostRequest() {
       RequestSpecification requestSpecification =  RequestSpec.reqResRequestSpec().basePath(USERS);

       //serialzation -> convert java object to json
       User user =  User.builder()
                .name(getRandomStringValue(6))
                .job(getRandomStringValue(5))
                .build();

        Response response =  sendPostRequest(requestSpecification, user);

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_CREATED, "status code is not matching");

        //de-serialzation -> convert json object to java
        User userResponse = response.as(User.class);

        Assert.assertEquals(userResponse.getName(), user.getName());
        Assert.assertEquals(userResponse.getJob(), user.getJob());
    }

    @Test
    public void patchUser() {
        RequestSpecification requestSpecification =  RequestSpec.reqResRequestSpec().basePath(USERS);

        //serialzation -> convert java object to json
        User user =  User.builder()
                .name(getRandomStringValue(6))
                .job(getRandomStringValue(5))
                .build();

        Response response =  sendPostRequest(requestSpecification, user);

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_CREATED, "status code is not matching");

        User userResponse = response.as(User.class);

        String id = userResponse.getId();

        requestSpecification = RequestSpec.reqResRequestSpec().basePath(USERS_ID).pathParams("id", id);

        user = User.builder()
                .name(getRandomStringValue(6))
                .job(getRandomStringValue(5))
                .build();

        response = sendPatchRequest(requestSpecification, user);

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
    }
}
