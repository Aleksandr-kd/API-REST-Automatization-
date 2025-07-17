package api.tests;

import api.base.AuthService;
import api.models.request.LoginRequest;
import api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static utils.ApiConstants.Patterns.JWT;

/**
 Assert.assertEquals(loginResponse)
 .satisfies(res -> {
 assertThat(res.getToken())
 .isNotBlank()
 .matches(JWT);

 assertThat(res.getType()).isEqualTo(BEARER_TYPE);
 assertThat(res.getId()).isPositive();
 assertThat(res.getUsername()).isEqualTo("uday888");
 assertThat(res.getEmail()).isNotBlank();

 assertThat(res.getRoles())
 .hasSize(1)
 .containsExactly(ROLE_USER);
 });
 *
 */

public class LoginAPITest {

    @Test(description = "Проверка верификации Login API")
    public void loginTest() {
        LoginRequest loginRequest = new LoginRequest("uday888", "uday888");
        AuthService authService = new AuthService();
        Response response = authService.login(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class);

        System.out.println(response.asPrettyString());
        System.out.println(loginResponse.getToken());
        System.out.println(loginResponse.getEmail());
        System.out.println(loginResponse.getId());


        Assert.assertNotNull(loginResponse.getToken());
        Assert.assertEquals(loginResponse.getEmail(),"als.dr@gmail.com");
        Assert.assertEquals(loginResponse.getId(), 2079);
        Assert.assertEquals(response.getStatusCode(), 200);

    }
}
