package api.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserReportResponse {
    private String accountNumber;
    private String fromDate;
    private String toDate;
}
