package api.base;

/**
 * BASE URI   CREATING THE REGUEST    HANDLING THE RESPONSE
 */

import api.filters.LoggingFilter;
import api.models.request.ReportRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import static io.restassured.RestAssured.given;


public class BaseService {

    private static final String BASE_URL = "http://64.227.160.186:8080";
    private final RequestSpecification requestSpecification;

    static
    {
        RestAssured.filters(new LoggingFilter());
    }

    public BaseService() {
        requestSpecification = given().baseUri(BASE_URL);
    }

    protected Response postRequest(Object payload, String endpoint) {
        return requestSpecification
                .contentType(ContentType.JSON)
                .body(payload)
                .post(endpoint);
    }

    protected Response getRequest(String endpoint) {
        return requestSpecification
                .get(endpoint);
    }

    protected Response getRequestWithParams(ReportRequest payload, String endpoint) {

        return requestSpecification
                .contentType(ContentType.JSON)
                .queryParam("accountNumber", payload.getAccountNumber())
                .get(endpoint);
    }

    protected Response putRequest(Object payload, String endpoint) {
        return requestSpecification
                .contentType(ContentType.JSON)
                .body(payload)
                .put(endpoint);
    }

    protected void setAuthToken(String token) {
        requestSpecification.
                header("Authorization", "Bearer " + token);
    }

    protected Response postRequest(String baseUrl, Object payload, String endpoint) {
        return requestSpecification
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .body(payload)
                .post(endpoint);
    }
}
