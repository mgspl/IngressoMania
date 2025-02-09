package br.edu.utfpr.futebol.api_jogos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiJogosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiJogosApplication.class, args);
	}

}
