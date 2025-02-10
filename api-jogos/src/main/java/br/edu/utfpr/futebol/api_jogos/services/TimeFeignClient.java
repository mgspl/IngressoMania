package br.edu.utfpr.futebol.api_jogos.services;

import br.edu.utfpr.futebol.api_jogos.dtos.TimesDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "api-times", url = "http://localhost:8083")
public interface TimeFeignClient {
    @GetMapping("/api-times/search/by-id/{id}")
    TimesDTO getTimeById(@PathVariable Long id);
}
