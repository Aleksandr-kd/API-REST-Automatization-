package api.tests.contract;

import api.base.AuthService;
import api.base.UserProfileManagementService;
import api.models.request.LoginRequest;
import api.models.request.SignUpRequest;
import api.models.response.LoginResponse;
import api.models.response.UserProfileResponse;
import api.testData.TestDataFactory;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class GetRequestProfileTest {

    private final TestDataFactory testData = new TestDataFactory();
    private final AuthService authService = new AuthService();
    private final UserProfileManagementService userProfileManagementService = new UserProfileManagementService();

    @Test(description = "Проверка Описание профиля пользователя")
    public void getProfileRequest() {
        SignUpRequest user = testData.createAccount();
        Response response = authService.login(new LoginRequest(user.getUsername(), user.getPassword()));
        LoginResponse loginResponse = response.as(LoginResponse.class);

        assertEquals(200, response.getStatusCode());

        response = userProfileManagementService.getProfile(loginResponse.getToken());
        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);

        assertEquals(userProfileResponse.getUsername(), user.getUsername());
    }
}
