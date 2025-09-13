package api.testData.factories;

import api.models.request.ReportRequest;
import api.models.request.SignUpRequest;
import api.testData.generators.RandomCredentialsGenerator;


public class ReportRequestFactory extends BaseFactory {

    public ReportRequestFactory(RandomCredentialsGenerator generator) {
        super(generator);
    }

    public ReportRequest accountMobileNumber(SignUpRequest user) {
        return ReportRequest.builder()
                .accountMobileNumber(user.getMobileNumber())
                .build();
    }
}