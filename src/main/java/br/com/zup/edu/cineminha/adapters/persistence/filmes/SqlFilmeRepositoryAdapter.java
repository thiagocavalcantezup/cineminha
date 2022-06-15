package br.com.zup.edu.cineminha.adapters.persistence.filmes;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.zup.edu.cineminha.domain.filmes.CadastraNovoFilmeRepository;
import br.com.zup.edu.cineminha.domain.filmes.EncontraFilmePorIdRepository;
import br.com.zup.edu.cineminha.domain.filmes.Filme;

@Repository
public class SqlFilmeRepositoryAdapter
        implements CadastraNovoFilmeRepository, EncontraFilmePorIdRepository {

    private final FilmeRepository repository;

    public SqlFilmeRepositoryAdapter(FilmeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Filme salva(Filme filme) {
        return repository.save(filme);
    }

    @Override
    public Optional<Filme> encontraPorId(Long id) {
        return repository.findById(id);
    }

}
