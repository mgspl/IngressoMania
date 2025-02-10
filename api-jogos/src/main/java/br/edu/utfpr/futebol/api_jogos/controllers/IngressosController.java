package br.edu.utfpr.futebol.api_jogos.controllers;

import br.edu.utfpr.futebol.api_jogos.model.Ingresso;
import br.edu.utfpr.futebol.api_jogos.repositories.IngressoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ingressos")
public class IngressosController {
    @Autowired
    IngressoRepository ingressoRepository;

    @GetMapping("/historico/{email}")
    public ResponseEntity<List<Ingresso>> getbyEmail(@Valid @PathVariable(name = "email") String email) {
        return ResponseEntity.ok(this.ingressoRepository.findAllByTorcedorEmail(email));
    }
}
