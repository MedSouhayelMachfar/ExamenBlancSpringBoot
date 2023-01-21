package com.axam.springrestapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.*;

// swagger url : http://localhost:9090/swagger-ui/index.html
@Configuration
public class OpenApiConfig {
    @Bean
    OpenAPI openApi() {
        return new OpenAPI()
            .info(new Info()
            .title("Examen API")
            .description("An API that can manage ...")
            .version("v1.0"));
    }
}