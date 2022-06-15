package br.com.zup.edu.cineminha.application.filmes;

import java.time.Duration;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.zup.edu.cineminha.domain.Classificacao;
import br.com.zup.edu.cineminha.domain.filmes.DadosNovoFilme;
import br.com.zup.edu.cineminha.domain.filmes.Filme;

public class NovoFilmeRequest implements DadosNovoFilme {

    @NotBlank
    private String nome;

    @Positive
    private long duracaoEmMinutos;

    @NotNull
    private Classificacao classificacao;

    public String getNome() {
        return nome;
    }

    public long getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public Filme toModel() {
        return new Filme(nome, Duration.ofMinutes(duracaoEmMinutos), classificacao);
    }

}
