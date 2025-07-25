package api.tests;

import api.base.AuthService;
import api.base.UserProfileManagementService;
import api.models.request.LoginRequest;
import api.models.response.LoginResponse;
import api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GetRequestProfileTest {

    @Test(description = "Получение описание профиля пользователя")
    public void getProfileRequest() {
        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("uday888","uday888"));
        LoginResponse loginResponse = response.as(LoginResponse.class);
        assertEquals(200, response.getStatusCode());

        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
        response = userProfileManagementService.getProfile(loginResponse.getToken());
        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);

        assertEquals(userProfileResponse.getUsername(), "uday888");
    }
}
