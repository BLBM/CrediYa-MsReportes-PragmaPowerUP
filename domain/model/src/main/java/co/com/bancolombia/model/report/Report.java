package co.com.bancolombia.model.report;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Report {

    private String reportId;
    private Long approvedLoansCount;
    private Double approvedLoansTotal;
}
