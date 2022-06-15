package br.com.zup.edu.cineminha.domain.filmes;

import org.springframework.stereotype.Service;

@Service
public class CadastraNovoFilme {

    private final CadastraNovoFilmeRepository repository;

    public CadastraNovoFilme(CadastraNovoFilmeRepository repository) {
        this.repository = repository;
    }

    public Filme salva(DadosNovoFilme dados) {
        return repository.salva(dados.toModel());
    }

}
