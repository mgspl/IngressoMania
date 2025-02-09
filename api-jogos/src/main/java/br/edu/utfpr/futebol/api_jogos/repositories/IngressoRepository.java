package br.edu.utfpr.futebol.api_jogos.repositories;
import br.edu.utfpr.futebol.api_jogos.model.Ingresso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngressoRepository extends JpaRepository<Ingresso, Long> {

}