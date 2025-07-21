package api.tests;

import api.base.AuthService;
import api.models.request.SignUpRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountCreationTest {

    @Test(description = "Верификация пользователя")
    public void createAccountTest() {
        SignUpRequest signUpRequest = new SignUpRequest.Builder()
                .userName("1111111111")
                .password("1111111111111")
                .email("aldddd@gmail.com")
                .firstName("Alldfgddr")
                .lastName("faadr")
                .mobileNumber("8884990012")
                .build();
        AuthService authService = new AuthService();
        Response response = authService.signUp(signUpRequest);
        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
