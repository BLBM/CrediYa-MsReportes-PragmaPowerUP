package co.com.bancolombia.api;

import co.com.bancolombia.api.mapper.ReportMapper;
import co.com.bancolombia.logconstants.logconstants.LogConstants;
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
                    log.info(LogConstants.GET_REPORT_HANDLER_SUCCESS);
                    return ServerResponse.ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .bodyValue(report);
                })
                .onErrorResume(ex -> {
                    log.error(LogConstants.ERROR_GET_REPORT_HANDLER_SUCCESS, ex);
                    return ServerResponse.status(500)
                            .contentType(MediaType.APPLICATION_JSON)
                            .bodyValue(LogConstants.ERROR_INTERN);
                });
    }
}
