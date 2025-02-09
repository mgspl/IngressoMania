package br.edu.utfpr.futebol.api_torcedores.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API de Torcedores",
                version = "1.0",
                description = "API para o gerenciamento dos Torcedores, inclui todas as operações de CRUD"
        )
)
public class OpenAPIConfig {
}
