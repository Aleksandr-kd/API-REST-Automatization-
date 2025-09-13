package api.tests.contract;

import api.base.AuthService;
import api.base.UserProfileManagementService;
import api.models.request.LoginRequest;
import api.models.request.ProfileRequest;
import api.models.request.SignUpRequest;
import api.models.response.LoginResponse;
import api.models.response.UserProfileResponse;
import api.testData.TestDataFactory;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class UpdateProfileTest {
    private final TestDataFactory testData = new TestDataFactory();
    private final AuthService authService = new AuthService();
    private final UserProfileManagementService userProfileManagementService = new UserProfileManagementService();

    @Test(description = "Проверка обновление профиля пользователя")
    public void updateProfileTest() {
        SignUpRequest user = testData.createAccount();
        Response response = authService.login(new LoginRequest(user.getUsername(), user.getPassword()));
        LoginResponse loginResponse = response.as(LoginResponse.class);

        response = userProfileManagementService.getProfile(loginResponse.getToken());

        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
        assertEquals(userProfileResponse.getUsername(), user.getUsername());

        ProfileRequest profileRequest = testData.updateProfile();

        response = userProfileManagementService.updateProfile(loginResponse.getToken(), profileRequest);
        assertEquals(response.getStatusCode(), 200, "Статус-код должен быть 200");

    }
}
