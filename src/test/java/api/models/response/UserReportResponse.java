package api.models.response;


public class UserReportResponse {
    private String accountNumber;
    private String fromDate;
    private String toDate;

    public UserReportResponse() {
    }

    public UserReportResponse(String accountNumber, String fromDate, String toDate) {
        this.accountNumber = accountNumber;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    @Override
    public String toString() {
        return "UserReportResponse{" +
                "accountNumber='" + accountNumber + '\'' +
                ", fromDate='" + fromDate + '\'' +
                ", toDate='" + toDate + '\'' +
                '}';
    }
}
