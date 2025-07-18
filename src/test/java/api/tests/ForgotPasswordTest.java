package api.tests;

import api.base.AuthService;
import io.restassured.response.Response;
import org.testng.annotations.Test;


public class ForgotPasswordTest {

    @Test(description = "Восстановление пароля пользователя")
    public void createAccountTest() {
        AuthService authService = new AuthService();
        Response response = authService.forgotPassword("alsd@mcmc.ru");
        System.out.println(response.asPrettyString());

    }
}
