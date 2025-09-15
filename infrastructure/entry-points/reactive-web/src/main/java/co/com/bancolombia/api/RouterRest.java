package co.com.bancolombia.api;

import co.com.bancolombia.model.report.Report;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterRest {

    @Bean
    @RouterOperations({
            @RouterOperation(
                    path = "/api/v1/report",
                    produces = {MediaType.APPLICATION_JSON_VALUE},
                    method = RequestMethod.GET,
                    beanClass = Handler.class,
                    beanMethod = "getReport",
                    operation = @Operation(
                            operationId = "getReport",
                            summary = "Obtener reporte",
                            description = "Devuelve un reporte en formato JSON",
                            tags = {"Report"},
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "Reporte obtenido exitosamente",
                                            content = @Content(
                                                    mediaType = "application/json",
                                                    schema = @Schema(implementation = Report.class)
                                            )
                                    ),
                                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                                    @ApiResponse(responseCode = "400", description = "Petición inválida"),
                                    @ApiResponse(responseCode = "500", description = "Error interno del servidor")
                            }
                    )
            )
    })
    public RouterFunction<ServerResponse> routerFunction(Handler handler) {
        return nest(path("/api/v1"),
                route(GET("report"), handler::getReport));

    }
}
