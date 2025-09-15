package common;


public enum ReportMessages {
    REPORT_NOT_FOUND("Report aggregate not found");

    private final String message;

    ReportMessages(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}