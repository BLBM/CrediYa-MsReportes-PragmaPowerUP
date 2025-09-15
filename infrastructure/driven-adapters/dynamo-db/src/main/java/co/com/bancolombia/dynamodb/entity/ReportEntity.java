package co.com.bancolombia.dynamodb.entity;

import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
@Setter
@DynamoDbBean
public class ReportEntity {
    private String reportId;
    private Long approvedLoansCount;
    private Double approvedLoansTotal;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("reportId")
    public String getReportId() { return reportId; }

    @DynamoDbAttribute("approvedLoansCount")
    public Long getApprovedLoansCount() { return approvedLoansCount; }

    @DynamoDbAttribute("approvedLoansTotal")
    public Double getApprovedLoansTotal() { return approvedLoansTotal; }
}