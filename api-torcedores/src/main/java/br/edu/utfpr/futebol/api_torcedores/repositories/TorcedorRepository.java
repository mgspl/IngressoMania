package br.edu.utfpr.futebol.api_torcedores.repositories;

import br.edu.utfpr.futebol.api_torcedores.model.Torcedores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TorcedorRepository extends JpaRepository<Torcedores,Long> {}
