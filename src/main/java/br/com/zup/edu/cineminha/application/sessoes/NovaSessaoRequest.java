package br.com.zup.edu.cineminha.application.sessoes;

import java.math.BigDecimal;
import java.time.LocalTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.zup.edu.cineminha.domain.filmes.EncontraFilmePorIdRepository;
import br.com.zup.edu.cineminha.domain.filmes.Filme;
import br.com.zup.edu.cineminha.domain.salas.EncontraSalaPorIdRepository;
import br.com.zup.edu.cineminha.domain.salas.Sala;
import br.com.zup.edu.cineminha.domain.sessoes.DadosNovaSessao;
import br.com.zup.edu.cineminha.domain.sessoes.Sessao;

public class NovaSessaoRequest implements DadosNovaSessao {

    @NotNull
    private LocalTime horario;

    @Positive
    private long salaId;

    @Positive
    private long filmeId;

    @Positive
    private BigDecimal preco;

    public LocalTime getHorario() {
        return horario;
    }

    public long getSalaId() {
        return salaId;
    }

    public long getFilmeId() {
        return filmeId;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Sessao toModel(EncontraSalaPorIdRepository salas, EncontraFilmePorIdRepository filmes) {
        Sala sala = salas.encontraPorId(salaId)
                         .orElseThrow(() -> new IllegalStateException("Sala nao existe"));
        Filme filme = filmes.encontraPorId(filmeId)
                            .orElseThrow(() -> new IllegalStateException("Filme nao existe"));

        return new Sessao(horario, sala, filme, preco);

    }

}
