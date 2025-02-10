package br.edu.utfpr.futebol.api_jogos.repositories;
import br.edu.utfpr.futebol.api_jogos.model.Ingresso;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngressoRepository extends JpaRepository<Ingresso, Long> {
    List<Ingresso> findAllByTorcedorEmail(@Email String torcedorEmail);
}