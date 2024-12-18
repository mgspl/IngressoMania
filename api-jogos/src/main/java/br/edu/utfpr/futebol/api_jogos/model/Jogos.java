package br.edu.utfpr.futebol.api_jogos.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Jogos {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jogo_seq")
    @SequenceGenerator(name = "jogo_seq", sequenceName = "jogo_seq", allocationSize = 1)
    private Long id;
    private String timeCasa;
    private String timeVisitante;
    private String estadio;
    private Double precoIngresso;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTimeCasa() {
        return timeCasa;
    }

    public void setTimeCasa(String timeCasa) {
        this.timeCasa = timeCasa;
    }

    public String getTimeVisitante() {
        return timeVisitante;
    }

    public void setTimeVisitante(String timeVisitante) {
        this.timeVisitante = timeVisitante;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public Double getPrecoIngresso() {
        return precoIngresso;
    }

    public void setPrecoIngresso(Double precoIngresso) {
        this.precoIngresso = precoIngresso;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
