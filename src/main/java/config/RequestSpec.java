package config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static utils.PropOperation.getEnvProperty;

public abstract class RequestSpec {

    private static final String REQ_RES_BASE_URI = getEnvProperty("reqresServiceUrl");
    private static final String EMPLOYEE_BASE_URI = getEnvProperty("employeeServiceUrl");
    private static final String GO_REST_BASE_URI = getEnvProperty("goRestServiceUrl");
    private static final String PET_BASE_URI = getEnvProperty("petServiceUrl");
    private static final String GO_REST_AUTH_TOKEN = getEnvProperty("goRestBearerToken");

    public static RequestSpecification employeeRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(EMPLOYEE_BASE_URI)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification petRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(PET_BASE_URI)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification reqResRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(REQ_RES_BASE_URI)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification goRestRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(GO_REST_BASE_URI)
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", GO_REST_AUTH_TOKEN)
                .build();
    }
}
