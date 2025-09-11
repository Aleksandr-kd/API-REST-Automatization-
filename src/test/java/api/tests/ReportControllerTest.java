package api.tests;

import api.base.AuthService;
import api.base.UserReportService;
import api.models.request.LoginRequest;
import api.models.request.ReportRequest;
import api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReportControllerTest {

    @Test(description = "Отчет для пользователя")
    public void reportControllerTest() {
        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("uday888", "uday888"));
        LoginResponse loginResponse = response.as(LoginResponse.class);

        UserReportService userReportService = new UserReportService();
        ReportRequest reportRequest = new ReportRequest.Builder()
                .accountNumber("2825512895")
                .build();

        response = userReportService.getReport(loginResponse.getToken(), reportRequest, "pdf");

        Assert.assertEquals(response.getStatusCode(), 200, "Статус-код должен быть 200");
        Assert.assertEquals(response.getContentType(), "application/pdf", "Неверный Content-Type");


    }
}