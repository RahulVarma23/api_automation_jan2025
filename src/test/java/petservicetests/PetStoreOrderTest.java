package petservicetests;

import base.BaseRequest;
import config.RequestSpec;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.models.PetStoreOrder;
import pojo.models.User;

import static config.RequestPath.STORE_ORDER;
import static config.RequestPath.USERS;
import static utils.RandomDataGenerator.getRandomIntValue;
import static utils.RandomDataGenerator.getRandomStringValue;

public class PetStoreOrderTest extends BaseRequest {

    @Test
    public void testPostPetOrderStore() {
        RequestSpecification requestSpecification =  RequestSpec.petRequestSpec().basePath(STORE_ORDER);

        //serialzation -> convert java object to json
        PetStoreOrder petStoreOrder =  PetStoreOrder.builder()
                .id(getRandomIntValue(1))
                .petId(getRandomIntValue(2))
                .complete(true)
                .quantity(1)
                .shipDate("2025-01-26T03:46:39.613Z")
                .build();

        Response response =  sendPostRequest(requestSpecification, petStoreOrder);


        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK, "status code is not matching");

        //de-serialzation -> convert json object to java
        PetStoreOrder petStoreOrderResponse = response.as(PetStoreOrder.class);

        Assert.assertEquals(petStoreOrderResponse.getPetId(), petStoreOrder.getPetId());
        Assert.assertEquals(petStoreOrderResponse.getId(), petStoreOrder.getId());
        Assert.assertEquals(petStoreOrderResponse.getQuantity(), petStoreOrder.getQuantity());
        Assert.assertEquals(petStoreOrderResponse.getStatus(), petStoreOrder.getStatus());
        Assert.assertEquals(petStoreOrderResponse.isComplete(), petStoreOrder.isComplete());
    }
}
