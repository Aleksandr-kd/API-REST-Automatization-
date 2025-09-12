package api.models.request;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@Builder
public class ReportRequest {
    private String accountNumber;
    private String fromDate;
    private String toDate;
}
