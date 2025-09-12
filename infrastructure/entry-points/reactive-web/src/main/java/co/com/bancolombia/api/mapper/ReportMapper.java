package co.com.bancolombia.api.mapper;

import co.com.bancolombia.api.dto.ReportResponse;
import co.com.bancolombia.model.report.Report;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReportMapper {

    ReportMapper INSTANCE = Mappers.getMapper(ReportMapper.class);

    ReportResponse toResponse(Report report);
}
