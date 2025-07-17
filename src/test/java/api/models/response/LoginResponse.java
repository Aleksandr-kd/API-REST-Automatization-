package api.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private String token;
    private String type;
    private int id;
    private String username;
    private String email;
    private List<String> roles;
}
