package br.edu.utfpr.futebol.api_jogos.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="ingresso")
@Table(name="ingresso")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Ingresso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Jogos jogo;

    private String torcedorEmail;

    public Ingresso(Jogos jogo, String torcedorEmail) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Jogos getJogo() {
        return jogo;
    }

    public void setJogo(Jogos jogo) {
        this.jogo = jogo;
    }

    public String getTorcedorEmail() {
        return torcedorEmail;
    }

    public void setTorcedorEmail(String torcedorEmail) {
        this.torcedorEmail = torcedorEmail;
    }
}
