package co.com.bancolombia.model.report.gateways;

import co.com.bancolombia.model.report.Report;
import reactor.core.publisher.Mono;

public interface ReportRepository {
    Mono<Report> findByReportId(String reportId);
}
