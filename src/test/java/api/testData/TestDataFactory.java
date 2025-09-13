package api.testData;

import api.models.request.ProfileRequest;
import api.models.request.ReportRequest;
import api.models.request.SignUpRequest;
import api.testData.factories.ProfileRequestFactory;
import api.testData.factories.ReportRequestFactory;
import api.testData.factories.UserFactory;
import api.testData.generators.RandomCredentialsGenerator;

public class TestDataFactory {
    private final RandomCredentialsGenerator generator;
    private final UserFactory userFactory;
    private final ReportRequestFactory reportFactory;
    private final ProfileRequestFactory profileFactory;

    public TestDataFactory() {
        this.generator = new RandomCredentialsGenerator();
        this.userFactory = new UserFactory(generator);
        this.reportFactory = new ReportRequestFactory(generator);
        this.profileFactory = new ProfileRequestFactory(generator);
    }

    public SignUpRequest createAccount() {
        return userFactory.createAccount();
    }

    public ReportRequest accountMobileNumber(SignUpRequest user) {
        return reportFactory.accountMobileNumber(user);
    }

    public ProfileRequest updateProfile() {
        return profileFactory.updateProfile();
    }
}