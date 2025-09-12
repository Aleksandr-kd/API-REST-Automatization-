package api.tests;

import api.base.AuthService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class ForgotPasswordTest {

    @Test(description = "Восстановление пароля пользователя")
    public void createAccountTest() {
        AuthService authService = new AuthService();
        Response response = authService.forgotPassword("alsd@mcmc.ru");
        assertEquals(response.jsonPath().getString("message"),
                "If your email exists in our system, you will receive reset instructions.");
    }
}
