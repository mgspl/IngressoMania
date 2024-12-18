package br.edu.utfpr.futebol.api_torcedores.model;

import jakarta.persistence.*;

@Entity
public class Torcedores {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "torcedor_seq")
    @SequenceGenerator(name = "torcedor_seq", sequenceName = "torcedor_seq", allocationSize = 1)
    private Long id;
    private String nome;
    private String email;

    public Torcedores(){

    }

    public Torcedores(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
