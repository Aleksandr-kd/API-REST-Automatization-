package api.tests;

import api.base.AuthService;
import api.models.request.LoginRequest;
import api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(api.listeners.TestListener.class)
public class LoginAPITest {

    @Test(description = "Проверка верификации Login API")
    public void loginTest() {
        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("uday888","uday888"));
        LoginResponse loginResponse = response.as(LoginResponse.class);

        Assert.assertNotNull(loginResponse.getToken());
        Assert.assertEquals(loginResponse.getEmail(),"als.dr@gmail.com");
        Assert.assertEquals(loginResponse.getId(), 2079);
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
