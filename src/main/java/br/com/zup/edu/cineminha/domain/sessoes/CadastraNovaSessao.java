package br.com.zup.edu.cineminha.domain.sessoes;

import org.springframework.stereotype.Service;

import br.com.zup.edu.cineminha.domain.filmes.EncontraFilmePorIdRepository;
import br.com.zup.edu.cineminha.domain.salas.EncontraSalaPorIdRepository;

@Service
public class CadastraNovaSessao {

    private final CadastraNovaSessaoRepository repository;
    private final EncontraSalaPorIdRepository salaRepository;
    private final EncontraFilmePorIdRepository filmeRepository;

    public CadastraNovaSessao(CadastraNovaSessaoRepository repository,
                              EncontraSalaPorIdRepository salaRepository,
                              EncontraFilmePorIdRepository filmeRepository) {
        this.repository = repository;
        this.salaRepository = salaRepository;
        this.filmeRepository = filmeRepository;
    }

    public Sessao salva(DadosNovaSessao dados) {
        return repository.salva(dados.toModel(salaRepository, filmeRepository));
    }

}
