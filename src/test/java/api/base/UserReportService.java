package api.base;

import io.restassured.response.Response;


public class UserReportService extends BaseService{
    private static final String BASE_PATH= "/api/reports/statement";

    public Response getReportPdf(String token) {
        setAuthToken(token);
        return getRequest(BASE_PATH + "/pdf");
    }

    public Response getReportExcel(String token) {
        setAuthToken(token);
        return getRequest(BASE_PATH + "/excel");
    }
}