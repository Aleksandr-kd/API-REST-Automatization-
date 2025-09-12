package api.tests;

import api.base.AuthService;
import api.models.request.SignUpRequest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AccountCreationTest {

    @Test(description = "Верификация пользователя")
    public void createAccountTest() {
        SignUpRequest signUpRequest = new SignUpRequest.Builder()
                .userName("11231")
                .password("13dfgdfg1")
                .email("als.dr@gmail.com")
                .firstName("erf8gddr")
                .lastName("ferfdfr")
                .mobileNumber("8822342012")
                .build();
        AuthService authService = new AuthService();
        Response response = authService.signUp(signUpRequest);

        assertEquals(response.asPrettyString(), "User registered successfully!");
        assertEquals(response.getStatusCode(), 200);
    }
}
