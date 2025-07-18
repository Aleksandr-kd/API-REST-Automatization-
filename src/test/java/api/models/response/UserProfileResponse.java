package api.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileResponse {
    private int id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String mobileNumber;
}
