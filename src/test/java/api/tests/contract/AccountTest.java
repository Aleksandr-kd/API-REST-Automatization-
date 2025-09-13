package api.tests.contract;

import api.base.AuthService;
import api.models.request.LoginRequest;
import api.models.request.SignUpRequest;
import api.models.response.LoginResponse;
import api.testData.TestDataFactory;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class AccountTest {
    private final TestDataFactory testData = new TestDataFactory();
    private final AuthService authService = new AuthService();

    @Test(description = "Проверка Создание пользователя")
    public void createAccountTest() {
        SignUpRequest user = testData.createAccount();
        Response response = authService.signUp(user);

        assertEquals(response.asPrettyString(), "User registered successfully!");
        assertEquals(response.getStatusCode(), 200);
    }

    @Test(description = "Проверка Восстановление пароля пользователя")
    public void forgotPasswordAccount() {
        SignUpRequest user = testData.createAccount();
        Response response = authService.forgotPassword(user.getEmail());

        assertEquals(response.jsonPath().getString("message"),
                "If your email exists in our system, you will receive reset instructions.");
    }

    @Test(description = "Проверка Верификации Login API")
    public void loginTest() {
        SignUpRequest user = testData.createAccount();
        Response response = authService.login(new LoginRequest(user.getUsername(), user.getPassword()));
        LoginResponse loginResponse = response.as(LoginResponse.class);

        Assert.assertNotNull(loginResponse.getToken());
        Assert.assertEquals(loginResponse.getEmail(),"Als@hnddmail.com");
        Assert.assertEquals(loginResponse.getId(), 2079);
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
