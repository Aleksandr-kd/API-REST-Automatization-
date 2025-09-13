package api.tests.contract;

import api.base.AuthService;
import api.base.UserReportService;
import api.models.request.LoginRequest;
import api.models.request.ReportRequest;
import api.models.request.SignUpRequest;
import api.models.response.LoginResponse;
import api.testData.TestDataFactory;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class ReportControllerTest {
    private final TestDataFactory testData = new TestDataFactory();
    private final AuthService authService = new AuthService();
    private final UserReportService userReportService = new UserReportService();

    @Test(description = "Проверка Отчет для пользователя")
    public void reportControllerTest() {
        SignUpRequest user = testData.createAccount();
        Response response = authService.login(new LoginRequest(user.getUsername(), user.getPassword()));
        LoginResponse loginResponse = response.as(LoginResponse.class);

        ReportRequest reportRequest = testData.accountMobileNumber(user);
        response = userReportService.getReport(loginResponse.getToken(), reportRequest, "pdf");

        assertEquals(response.getStatusCode(), 200, "Статус-код должен быть 200");
        assertEquals(response.getContentType(), "application/pdf", "Неверный Content-Type");
    }
}