package co.com.bancolombia.usecase.get_report;


import co.com.bancolombia.model.report.Report;

import co.com.bancolombia.model.report.gateways.ReportRepository;

import co.com.bancolombia.usecase.common.ReportMessages;
import co.com.bancolombia.usecase.exception.DomainException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.*;

class GetReportUseCaseTest {

    private ReportRepository reportRepository;
    private GetReportUseCase getReportUseCase;

    @BeforeEach
    void setUp() {
        reportRepository = mock(ReportRepository.class);
        getReportUseCase = new GetReportUseCase(reportRepository);
    }

    @Test
    void shouldReturnReportWhenExists() {
        Report report = Report.builder()
                .reportId("REPORT-AGGREGATE")
                .approvedLoansCount(10L)
                .approvedLoansTotal(1000.0)
                .build();

        when(reportRepository.findByReportId("REPORT-AGGREGATE"))
                .thenReturn(Mono.just(report));

        StepVerifier.create(getReportUseCase.getReport())
                .expectNextMatches(r ->
                        r.getReportId().equals("REPORT-AGGREGATE") &&
                                r.getApprovedLoansCount() == 10L &&
                                r.getApprovedLoansTotal() == 1000.0
                )
                .verifyComplete();

        verify(reportRepository, times(1)).findByReportId("REPORT-AGGREGATE");
    }

    @Test
    void shouldThrowDomainExceptionWhenNotFound() {
        when(reportRepository.findByReportId("REPORT-AGGREGATE"))
                .thenReturn(Mono.empty());

        StepVerifier.create(getReportUseCase.getReport())
                .expectErrorMatches(throwable ->
                        throwable instanceof DomainException &&
                                throwable.getMessage().equals(ReportMessages.REPORT_NOT_FOUND.message())
                )
                .verify();

        verify(reportRepository, times(1)).findByReportId("REPORT-AGGREGATE");
    }
}
