package br.com.zup.edu.cineminha.domain.sessoes;

import br.com.zup.edu.cineminha.domain.filmes.EncontraFilmePorIdRepository;
import br.com.zup.edu.cineminha.domain.salas.EncontraSalaPorIdRepository;

public interface DadosNovaSessao {

    Sessao toModel(EncontraSalaPorIdRepository salaRepository,
                   EncontraFilmePorIdRepository filmeRepository);

}
