package co.com.bancolombia.api.dto;


public record ReportResponse (
        String reportId,
        Long approvedLoansCount,
        Double approvedLoansTotal
){

}
