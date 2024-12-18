package com.te29s.apitimes.controllers;

import com.te29s.apitimes.models.ClubModel;
import com.te29s.apitimes.repositories.ClubRepo;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api-times")
//TODO: Achar um jeito melhor de anotar os endpoints com o Swagger
public class ClubController {
    @Autowired
    private ClubRepo repo;

   @GetMapping(path = "/search")
   public ResponseEntity<List<ClubModel>> listAllClubs(){
       return ResponseEntity.ok(this.repo.findAll());
   }

   @GetMapping(path = "/search/by-id/{id}")
   public ResponseEntity<ClubModel> listOneClub(@NonNull @PathVariable(name = "id") Long id){
       ClubModel club = this.repo.findById(id).orElse(null);

       // Checa se NÃO achou o time
       if (club == null)
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

       return ResponseEntity.status(HttpStatus.OK).body(club);
   }

   //TODO: Remover o case sensitive da query de procura por nome
    @GetMapping(path = "/search/by-name/{name}")
    public ResponseEntity<List<ClubModel>> listClubsByName(@NonNull @PathVariable(name = "name") String name){
        return ResponseEntity.ok(this.repo.findAllByKnownnameContaining(name));
    }

    @GetMapping(path = "/search/by-city/{city}")
    public ResponseEntity<List<ClubModel>> listClubsPerCity(@NonNull @PathVariable(name = "city") String city){
        return ResponseEntity.ok(this.repo.findAllByCityContaining(city));
    }

    @GetMapping(path = "/search/by-state/{state}")
    public ResponseEntity<List<ClubModel>> listClubsPerState(@Valid @NonNull @PathVariable(name = "state") String state){
        return ResponseEntity.ok(this.repo.findAllByState(state));
    }

    @PostMapping(path = "/create")
    public ResponseEntity<String> addOneClub(@Valid @NonNull @RequestBody ClubModel newClub){
       this.repo.saveAndFlush(newClub);

       return ResponseEntity.status(HttpStatus.CREATED).body("Time cadastrado com sucesso!");
   }

   //TODO: Modificar para usar o PATCH
   @PutMapping(path = "/update/{id}")
   public ResponseEntity<String> updOneClub(@Valid @NonNull @RequestBody ClubModel clubUpd, @PathVariable(name = "id") Long id){
       ClubModel club = this.repo.findById(id).orElse(null);

       if (club == null){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Time não encontrado, nenhuma mudança foi feita");
       }

       club.setFullname(clubUpd.getFullname());
       club.setKnownname(clubUpd.getKnownname());
       club.setFansname(clubUpd.getFansname());
       club.setNickname(clubUpd.getNickname());
       club.setCity(clubUpd.getCity());
       club.setState(clubUpd.getState());
       club.setStadium(clubUpd.getStadium());
       this.repo.save(club);

       return ResponseEntity.status(HttpStatus.OK).body("Time atualizado com sucesso");

   }

   @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteOneClub(@NonNull @PathVariable(name = "id") Long id){
       this.repo.deleteById(id);

       return ResponseEntity.status(HttpStatus.OK).body("Time deletado");
   }

}
