package api.testData.factories;

import api.models.request.ProfileRequest;
import api.testData.generators.RandomCredentialsGenerator;

public class ProfileRequestFactory extends BaseFactory {

    public ProfileRequestFactory(RandomCredentialsGenerator generator) {
        super(generator);
    }

    public ProfileRequest updateProfile() {
        return ProfileRequest.builder()
                .email(generator.generateEmail(6, 12))
                .firstName(generator.generateFirstName(6, 12))
                .lastName(generator.generateLastName(6, 12))
                .mobileNumber(generator.generateMobileNumber(10, 10))
                .build();
    }
}