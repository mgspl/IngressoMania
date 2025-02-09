package br.edu.utfpr.futebol.api_jogos.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API de Jogos",
                version = "1.0",
                description = "API para o gerenciamento dos Jogos, inclui todas as operações de CRUD, e busca por data"
        )
)
public class OpenAPIConfig {
}
