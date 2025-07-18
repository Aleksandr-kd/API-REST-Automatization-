package api.models.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReportRequest {
    private String accountNumber;
    private String fromDate;
    private String toDate;

    public static class Builder {
        private String accountNumber;
        private String fromDate;
        private String toDate;

        public Builder accountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder fromDate(String fromDate) {
            this.fromDate = fromDate;
            return this;
        }

        public Builder toDate(String toDate) {
            this.toDate = toDate;
            return this;
        }

        public ReportRequest build() {
            return new ReportRequest(accountNumber, fromDate, toDate);
        }
    }
}
