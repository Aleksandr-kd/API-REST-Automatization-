package api.filters;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LoggingFilter implements Filter {
    private static final Logger logger = LogManager.getLogger(LoggingFilter.class);

    @Override
    public Response filter(FilterableRequestSpecification requestSpec,
                           FilterableResponseSpecification responseSpec,
                           FilterContext ctx) {
        logRequest(requestSpec);

        Response response = ctx.next(requestSpec, responseSpec);
        logResponse(response);
        return response;
    }

    private void logRequest(FilterableRequestSpecification requestSpec) {
        logger.info("Request: {} {}", requestSpec.getMethod(), requestSpec.getURI());
        logger.info("BASE URI: {}", requestSpec.getBaseUri());
        logger.info("Request Header: {}", requestSpec.getHeaders());
        logger.info("Request Payload: " + requestSpec.getBody());
    }

    private void logResponse(Response response) {
        logger.info("Response Status: {}", response.getStatusCode());
        logger.info("Response Header: {}", response.headers());
        logger.info("Request Body: {}", response.getBody().prettyPrint());
    }
}


