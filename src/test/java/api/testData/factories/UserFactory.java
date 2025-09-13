package api.testData.factories;

import api.models.request.SignUpRequest;
import api.testData.generators.RandomCredentialsGenerator;

public class UserFactory extends BaseFactory{
    public UserFactory(RandomCredentialsGenerator generator) {
        super(generator);
    }

    public SignUpRequest createAccount() {
        return SignUpRequest.builder()
                .username(generator.generateUsername(6, 12))
                .password(generator.generatePassword(8, 16))
                .email(generator.generateEmail(6, 12))
                .firstName(generator.generateFirstName(6, 12))
                .lastName(generator.generateLastName(6, 12))
                .mobileNumber(generator.generateMobileNumber(10, 10))
                .address(generator.generateAddress(6, 50))
                .build();
    }
}