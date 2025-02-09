package br.edu.utfpr.futebol.api_torcedores.controllers;


import br.edu.utfpr.futebol.api_torcedores.dtos.TorcedoresDTO;
import br.edu.utfpr.futebol.api_torcedores.model.Torcedores;
import br.edu.utfpr.futebol.api_torcedores.repositories.TorcedorRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/torcedores")
public class TorcedoresController {

    private TorcedorRepository repository;

    public TorcedoresController(TorcedorRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Torcedores>> getAll(){
        return ResponseEntity.ok(this.repository.findAll());
    }

    @PostMapping
    public ResponseEntity<String> addOne(@Valid @RequestBody Torcedores torcedor) {
        if (torcedor.getNome() == null || torcedor.getEmail() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nome ou E-mail inválidos");
        } else {
            this.repository.save(torcedor);
            return ResponseEntity.status(HttpStatus.CREATED).body("Torcedor cadastrado com sucesso");
        }
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<String> update(@Valid @PathVariable(name="id") Long idTorcedor, @RequestBody Torcedores torcedor) {
        Torcedores torcedorDB = this.repository.findById(idTorcedor).orElse(null);
        if (torcedorDB != null){
            torcedorDB.setNome(torcedor.getNome());
            torcedorDB.setEmail(torcedor.getEmail());
            this.repository.save(torcedorDB);
            return ResponseEntity.ok("Registro de torcedor atualizado com sucesso.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Torcedor não encontrado.");
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable(name="id") Long idTorcedor){
        Torcedores torcedorRemover = this.repository.findById(idTorcedor).orElse(null);
        if (torcedorRemover != null){
            this.repository.delete(torcedorRemover);
            return ResponseEntity.status(HttpStatus.OK).body("Torcedor removido com sucesso.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Torcedor não encontrado");
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<TorcedoresDTO> getOne(@PathVariable(name = "id") Long idTorcedor){
        Torcedores torcedorEncontrado = this.repository.findById(idTorcedor).orElse(null);
        if (torcedorEncontrado == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        else{
            TorcedoresDTO torcedoresDTO = new TorcedoresDTO(
                    torcedorEncontrado.getId(),
                    torcedorEncontrado.getNome(),
                    torcedorEncontrado.getEmail()
            );
            return ResponseEntity.status(HttpStatus.OK).body(torcedoresDTO);
        }
    }

}
