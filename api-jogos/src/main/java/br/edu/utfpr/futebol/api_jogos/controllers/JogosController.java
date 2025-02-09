package br.edu.utfpr.futebol.api_jogos.controllers;

import br.edu.utfpr.futebol.api_jogos.dtos.JogosDTO;
import br.edu.utfpr.futebol.api_jogos.model.Jogos;
import br.edu.utfpr.futebol.api_jogos.repositories.JogoRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping(path = "/jogos")
public class JogosController {
    private JogoRepository repository;

    public JogosController(JogoRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Jogos>> getAll(){
        return ResponseEntity.ok(this.repository.findAll());
    }

    @PostMapping
    public ResponseEntity<String> addOne(@Valid @RequestBody Jogos jogo) {
        if (jogo.getEstadio() == null || jogo.getDataHora() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registro de jogo inválido");
        } else {
            this.repository.save(jogo);
            return ResponseEntity.status(HttpStatus.CREATED).body("Jogo cadastrado com sucesso");
        }
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<String> update(@Valid @PathVariable(name="id") Long idJogo, @RequestBody Jogos jogo) {
        Jogos jogoDB = this.repository.findById(idJogo).orElse(null);
        if (jogoDB != null){
            jogoDB.setTimeCasa(jogo.getTimeCasa());
            jogoDB.setTimeVisitante(jogo.getTimeVisitante());
            jogoDB.setEstadio(jogo.getEstadio());
            jogoDB.setPrecoIngresso(jogo.getPrecoIngresso());
            jogoDB.setDataHora(jogo.getDataHora());
            this.repository.save(jogoDB);
            return ResponseEntity.ok("Registro de jogo atualizado com sucesso.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Jogo não encontrado.");
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable(name="id") Long idJogo){
        Jogos jogoRemover = this.repository.findById(idJogo).orElse(null);
        if (jogoRemover != null){
            this.repository.delete(jogoRemover);
            return ResponseEntity.status(HttpStatus.OK).body("Jogo removido com sucesso.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Jogo não encontrado.");
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<JogosDTO> getOne(@PathVariable(name = "id") Long idJogo){
        Jogos jogoEncontrado = this.repository.findById(idJogo).orElse(null);
        if (jogoEncontrado == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        else{
            JogosDTO jogosDTO = new JogosDTO(
                    jogoEncontrado.getId(),
                    jogoEncontrado.getTimeCasa(),
                    jogoEncontrado.getTimeVisitante(),
                    jogoEncontrado.getEstadio(),
                    jogoEncontrado.getPrecoIngresso(),
                    jogoEncontrado.getDataHora()
            );
            return ResponseEntity.status(HttpStatus.OK).body(jogosDTO);
        }
    }

    @GetMapping("/buscar-por-data")
    public ResponseEntity<List<JogosDTO>> buscarPorDataHora(@RequestParam String dataHora) {
        try {
            // Converter o parâmetro para LocalDateTime
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
            LocalDateTime dataHoraFormatada = LocalDateTime.parse(dataHora, formatter);

            // Buscar jogos pelo repositório
            List<Jogos> jogosEncontrados = repository.findByDataHora(dataHoraFormatada);

            // Mapear para DTOs
            List<JogosDTO> jogosDTOs = jogosEncontrados.stream()
                    .map(jogo -> new JogosDTO(
                            jogo.getId(),
                            jogo.getTimeCasa(),
                            jogo.getTimeVisitante(),
                            jogo.getEstadio(),
                            jogo.getPrecoIngresso(),
                            jogo.getDataHora()
                    ))
                    .toList();

            return ResponseEntity.ok(jogosDTOs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
