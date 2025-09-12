package co.com.bancolombia.api;

import co.com.bancolombia.api.mapper.ReportMapper;
import co.com.bancolombia.usecase.get_report.GetReportUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class Handler {


private  final GetReportUseCase getReportUseCase;

    public Mono<ServerResponse> getReport(ServerRequest request) {
        return getReportUseCase.getReport()
                .map(ReportMapper.INSTANCE::toResponse)
                .flatMap(report -> {
                    log.info("Report retrieved successfully");
                    return ServerResponse.ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .bodyValue(report);
                })
                .onErrorResume(ex -> {
                    log.error("Error retrieving report", ex);
                    return ServerResponse.status(500)
                            .contentType(MediaType.APPLICATION_JSON)
                            .bodyValue("Internal error retrieving report");
                });
    }
}
