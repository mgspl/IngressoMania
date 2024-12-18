package br.edu.utfpr.futebol.api_jogos.repositories;

import br.edu.utfpr.futebol.api_jogos.model.Jogos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface JogoRepository extends JpaRepository<Jogos,Long> {
    List<Jogos> findByDataHora(LocalDateTime dataHora);
}
