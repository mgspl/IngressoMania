package br.edu.utfpr.futebol.api_jogos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class Jogos {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jogo_seq")
    @SequenceGenerator(name = "jogo_seq", sequenceName = "jogo_seq", allocationSize = 1)
    private Long id;
    @NotNull
    @NonNull
    private String timeCasa;
    @NotNull
    @NonNull
    private String timeVisitante;
    @NotNull
    @NonNull
    private String estadio;
    @NotNull
    @NonNull
    @Min( value = 1)
    private Double precoIngresso;
    @NotNull
    @NonNull
    private LocalDateTime dataHora;
    public Jogos(){

    }

    public Jogos(Long id, String timeCasa, String timeVisitante, String estadio, Double precoIngresso, LocalDateTime dataHora) {
        this.id = id;
        this.timeCasa = timeCasa;
        this.timeVisitante = timeVisitante;
        this.estadio = estadio;
        this.precoIngresso = precoIngresso;
        this.dataHora = dataHora;
    }

}
