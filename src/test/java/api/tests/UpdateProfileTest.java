package api.tests;

import api.base.AuthService;
import api.base.UserProfileManagementService;
import api.models.request.LoginRequest;
import api.models.request.ProfileRequest;
import api.models.response.LoginResponse;
import api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateProfileTest {

    @Test(description = "Обновление профиля пользователя")
    public void updateProfileTest() {
        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("uday888", "uday888"));
        LoginResponse loginResponse = response.as(LoginResponse.class);

        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
        response = userProfileManagementService.getProfile(loginResponse.getToken());

        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
        Assert.assertEquals(userProfileResponse.getUsername(), "uday888");
        ProfileRequest profileRequest = ProfileRequest.builder()
                .firstName("Aswer")
                .lastName("rtyuqerwy")
                .email("Als@hnddmail.com")
                .mobileNumber("1288567890")
                .build();

        response = userProfileManagementService.updateProfile(loginResponse.getToken(), profileRequest);
        Assert.assertEquals(response.getStatusCode(), 200, "Статус-код должен быть 200");

    }
}
