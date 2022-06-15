package br.com.zup.edu.cineminha.model;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

import java.time.Duration;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Filme {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotNull
    private Duration duracao;

    @NotNull
    @Enumerated(STRING)
    private Classificacao classificacao;

    /**
     * @deprecated hibernate apenas
     */
    public Filme() {}

    public Filme(String nome, Duration duracao, Classificacao classificacao) {
        this.nome = nome;
        this.duracao = duracao;
        this.classificacao = classificacao;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Filme [classificacao=" + classificacao + ", duracao=" + duracao + ", id=" + id
                + ", nome=" + nome + "]";
    }

}
