package base;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public abstract class BaseRequest {

    public Response sendGetRequest(RequestSpecification specification) {
        return given().spec(specification).when().get().then().extract().response();
    }

    public Response sendPostRequest(RequestSpecification specification, Object body) {
        return given().spec(specification).body(body).log().all().when().post().then().log().all().extract().response();
    }

    public Response sendDeleteRequest(RequestSpecification specification) {
        return given().spec(specification).when().delete().then().extract().response();
    }

    public Response sendPatchRequest(RequestSpecification specification, Object body) {
        return given().spec(specification).body(body).log().all().when().patch().then().log().all().extract().response();
    }

    public Response sendPutRequest(RequestSpecification specification, Object body) {
        return given().spec(specification).body(body).when().put().then().extract().response();
    }

}
