package api.models.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProfileRequest {
    private String email;
    private String firstName;
    private String lastName;
    private String mobileNumber;

    public static class Builder {
        private String email;
        private String firstName;
        private String lastName;
        private String mobileNumber;

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder mobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        public ProfileRequest build() {
            return new ProfileRequest(email, firstName, lastName, mobileNumber);
        }
    }
}