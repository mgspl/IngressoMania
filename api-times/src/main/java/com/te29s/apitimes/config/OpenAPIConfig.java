package com.te29s.apitimes.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API de Times",
                version = "1.0",
                description = "API para o gerenciamento dos Times, inclui todas as operações de CRUD, e busca por Nome, cidade ou estado"
        )
)
public class OpenAPIConfig {
}
