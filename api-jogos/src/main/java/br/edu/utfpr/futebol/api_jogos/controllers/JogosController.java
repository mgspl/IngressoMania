package br.edu.utfpr.futebol.api_jogos.controllers;
import br.edu.utfpr.futebol.api_jogos.dtos.IngressoRequestDTO;
import br.edu.utfpr.futebol.api_jogos.dtos.JogoRequestDTO;
import br.edu.utfpr.futebol.api_jogos.model.Jogos;
import br.edu.utfpr.futebol.api_jogos.repositories.JogoRepository;
import br.edu.utfpr.futebol.api_jogos.services.JogoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private JogoService jogoService;

    @GetMapping
    public List<Jogos> getAllGames() {
        return jogoService.getAllGames();
    }

    @GetMapping("/upcoming")
    public List<Jogos> getUpcomingGames() {
        return jogoService.getUpcomingGames();
    }

    @PostMapping
    public Jogos createGame(@RequestBody JogoRequestDTO jogo) {
        return jogoService.createGame(jogo);
    }

    @PostMapping("/{jogoId}/register")
    public void registerFan(@PathVariable String jogoId, @RequestBody IngressoRequestDTO ingressoRequest) {
        jogoService.registerFan(jogoId, ingressoRequest.torcedorEmail());
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<String> update(@Valid @PathVariable(name="id") String idJogo, @RequestBody Jogos jogo) {
        Jogos jogoDB = this.repository.findById(idJogo).orElse(null);
        if (jogoDB != null){
            jogoDB.setTimeCasa(jogo.getTimeCasa());
            jogoDB.setTimeVisitante(jogo.getTimeVisitante());
            jogoDB.setEstadio(jogo.getEstadio());
            jogoDB.setPrecoIngresso(jogo.getPrecoIngresso());
            jogoDB.setDataJogo(jogo.getDataJogo());
            this.repository.save(jogoDB);
            return ResponseEntity.ok("Registro de jogo atualizado com sucesso.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Jogo não encontrado.");
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable(name="id") String idJogo){
        Jogos jogoRemover = this.repository.findById(idJogo).orElse(null);
        if (jogoRemover != null){
            this.repository.delete(jogoRemover);
            return ResponseEntity.status(HttpStatus.OK).body("Jogo removido com sucesso.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Jogo não encontrado.");
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<JogoRequestDTO> getOne(@PathVariable(name = "id") String idJogo){
        Jogos jogoEncontrado = this.repository.findById(idJogo).orElse(null);
        if (jogoEncontrado == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        else{
            JogoRequestDTO jogosDTO = new JogoRequestDTO(
                    jogoEncontrado.getId(),
                    jogoEncontrado.getMaxFans(),
                    jogoEncontrado.getRegisteredFans(),
                    jogoEncontrado.getTimeCasa(),
                    jogoEncontrado.getTimeVisitante(),
                    jogoEncontrado.getEstadio(),
                    jogoEncontrado.getPrecoIngresso(),
                    jogoEncontrado.getDataJogo()
            );
            return ResponseEntity.status(HttpStatus.OK).body(jogosDTO);
        }
    }

    @GetMapping("/buscar-por-data")
    public ResponseEntity<List<JogoRequestDTO>> buscarPorDataHora(@RequestParam String dataJogo) {
        try {
            // Converter o parâmetro para LocalDateTime
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
            LocalDateTime dataHoraFormatada = LocalDateTime.parse(dataJogo, formatter);

            // Buscar jogos pelo repositório
            List<Jogos> jogosEncontrados = repository.findUpcomingGames(dataHoraFormatada);

            // Mapear para DTOs
            List<JogoRequestDTO> jogosDTOs = jogosEncontrados.stream()
                    .map(jogo -> new JogoRequestDTO(
                            jogo.getId(),
                            jogo.getMaxFans(),
                            jogo.getRegisteredFans(),
                            jogo.getTimeCasa(),
                            jogo.getTimeVisitante(),
                            jogo.getEstadio(),
                            jogo.getPrecoIngresso(),
                            jogo.getDataJogo()
                    ))
                    .toList();

            return ResponseEntity.ok(jogosDTOs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
