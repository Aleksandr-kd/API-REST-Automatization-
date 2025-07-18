package api.tests;

import api.base.AuthService;
import api.base.UserReportService;
import api.models.request.LoginRequest;
import api.models.request.ReportRequest;
import api.models.response.LoginResponse;
import api.models.response.UserReportResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReportControllerTest {

    @Test(description = "Отчет для пользователя")
    public void ReportControllerTest() {
        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("uday888", "uday888"));
        LoginResponse loginResponse = response.as(LoginResponse.class);

        System.out.println(response.asPrettyString());

        UserReportService userReportService = new UserReportService();
        response = userReportService.getReportPdf(loginResponse.getToken());
        System.out.println(response.asPrettyString());

        UserReportResponse userReportResponse = response.as(UserReportResponse.class);
        Assert.assertEquals(userReportResponse.getStatus(), 200);

        ReportRequest reportRequest = new ReportRequest.Builder()
                .accountNumber("2825515895")
//                .toDate("18-07-2025")
//                .fromDate("10-07-2025")
                .build();
//
//        response = userReportService.getReportPdf(loginResponse.getToken());
//        System.out.println(response.asPrettyString());
//
//
        userReportResponse = response.as(UserReportResponse.class);
        System.out.println(userReportResponse.getAccountNumber());


    }
}