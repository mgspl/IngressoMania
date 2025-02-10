package br.edu.utfpr.futebol.api_jogos.model;

import br.edu.utfpr.futebol.api_jogos.dtos.JogoRequestDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.NonNull;


import java.time.LocalDateTime;
import java.util.UUID;


@Entity(name="jogos")
@Table(name="jogos")
@EqualsAndHashCode(of="id")
public class Jogos {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @NotNull
    @NonNull
    @Min(value = 1)
    private int maxFans;
    @NotNull
    @NonNull
    private int registeredFans;
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
    private String dataJogo;
    @NotNull
    @NonNull

    public String getId() {
        return id;
    }

    public int getMaxFans() {
        return maxFans;
    }

    public int getRegisteredFans() {
        return registeredFans;
    }

    public String getTimeCasa() {
        return timeCasa;
    }

    public String getTimeVisitante() {
        return timeVisitante;
    }

    public String getEstadio() {
        return estadio;
    }

    public Double getPrecoIngresso() {
        return precoIngresso;
    }

    public String getDataJogo() {
        return dataJogo;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setMaxFans(int maxFans) {
        this.maxFans = maxFans;
    }

    public void setRegisteredFans(int registeredFans) {
        this.registeredFans = registeredFans;
    }

    public void setTimeCasa(String timeCasa) {
        this.timeCasa = timeCasa;
    }

    public void setTimeVisitante(String timeVisitante) {
        this.timeVisitante = timeVisitante;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public void setPrecoIngresso(Double precoIngresso) {
        this.precoIngresso = precoIngresso;
    }

    public void setDataJogo(String dataJogo) {
        this.dataJogo = dataJogo;
    }

    public Jogos(){

    }

    public Jogos(String id, String timeCasa, String timeVisitante, String estadio, Double precoIngresso, String dataJogo) {
        this.id = id;
        this.timeCasa = timeCasa;
        this.timeVisitante = timeVisitante;
        this.estadio = estadio;
        this.precoIngresso = precoIngresso;
        this.dataJogo = dataJogo;
    }

   /* public Jogos(JogoRequestDTO jogoRequest){
        this.maxFans = jogoRequest.maxFans();
        this.registeredFans = jogoRequest.registeredFans();
        this.timeCasa = jogoRequest.timeCasa();
        this.timeVisitante = jogoRequest.timeVisitante();
        this.estadio = jogoRequest.estadio();
        this.precoIngresso = jogoRequest.precoIngresso();
        this.dataJogo = jogoRequest.dataJogo();
    } */

}
