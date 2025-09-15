package co.com.bancolombia.usecase.get_report;

import co.com.bancolombia.model.report.Report;
import co.com.bancolombia.model.report.gateways.ReportRepository;
import common.ReportMessages;
import exception.DomainException;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class GetReportUseCase {

    private final ReportRepository reportRepository;

    public Mono<Report> getReport() {
        return reportRepository.findByReportId("REPORT-AGGREGATE")
                .switchIfEmpty(Mono.error(new DomainException(ReportMessages.REPORT_NOT_FOUND.message())));
    }
}
