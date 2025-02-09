package br.edu.utfpr.futebol.api_jogos.repositories;

import br.edu.utfpr.futebol.api_jogos.model.Jogos;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface JogoRepository extends JpaRepository<Jogos, String> {

    @Query(value = "SELECT * FROM jogos j WHERE parsedatetime(j.DATA_JOGO, 'dd/MM/yyyy') > :currentDate", nativeQuery = true)
    List<Jogos> findUpcomingGames(@Param("currentDate") LocalDateTime currentDate);

    @Nonnull
    Optional<Jogos> findById(@Nonnull String id);
}
