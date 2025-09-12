package co.com.bancolombia.config;

import co.com.bancolombia.model.report.gateways.ReportRepository;
import co.com.bancolombia.usecase.get_report.GetReportUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "co.com.bancolombia.usecase",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+UseCase$")
        },
        useDefaultFilters = false)
public class UseCasesConfig {

    @Bean
    public GetReportUseCase getReportUseCase(ReportRepository reportRepository) {
        return new GetReportUseCase(reportRepository);
    }
}
