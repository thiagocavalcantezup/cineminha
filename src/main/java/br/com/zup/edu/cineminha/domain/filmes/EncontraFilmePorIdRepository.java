package br.com.zup.edu.cineminha.domain.filmes;

import java.util.Optional;

public interface EncontraFilmePorIdRepository {

    Optional<Filme> encontraPorId(Long id);

}
