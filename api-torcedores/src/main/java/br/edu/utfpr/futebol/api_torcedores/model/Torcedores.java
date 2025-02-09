package br.edu.utfpr.futebol.api_torcedores.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Torcedores {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "torcedor_seq")
    @SequenceGenerator(name = "torcedor_seq", sequenceName = "torcedor_seq", allocationSize = 1)
    private Long id;
    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 100, message = "Nome deve conter de 3 a 100 caracteres")
    private String nome;
    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    public Torcedores(){

    }

    public Torcedores(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

}
