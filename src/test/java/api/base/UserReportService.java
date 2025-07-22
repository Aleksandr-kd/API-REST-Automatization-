package api.base;

import api.models.request.ReportRequest;
import io.restassured.response.Response;


public class UserReportService extends BaseService {
    private static final String BASE_PATH = "/api/reports/statement/";

    public Response getReport(String token, ReportRequest params, String url) {
        setAuthToken(token);
        return getRequestWithParams(params, BASE_PATH + url);
    }
}

