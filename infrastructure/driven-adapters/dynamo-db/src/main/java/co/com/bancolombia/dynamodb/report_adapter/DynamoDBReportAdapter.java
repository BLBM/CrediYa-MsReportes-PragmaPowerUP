package co.com.bancolombia.dynamodb.report_adapter;


import co.com.bancolombia.dynamodb.entity.ReportEntity;
import co.com.bancolombia.dynamodb.helper.TemplateAdapterOperations;
import co.com.bancolombia.model.report.Report;
import co.com.bancolombia.model.report.gateways.ReportRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;



@Repository
public class DynamoDBReportAdapter extends TemplateAdapterOperations<Report, String, ReportEntity> implements ReportRepository {

    public DynamoDBReportAdapter(DynamoDbEnhancedAsyncClient connectionFactory, ObjectMapper mapper, @Value("${aws.dynamodb.table-name}") String tableName) {
        super(connectionFactory, mapper, d -> mapper.map(d, Report.class), tableName);
    }

    @Override
    public Mono<Report> findByReportId(String reportId) {
        return super.getById(reportId);
    }
}
