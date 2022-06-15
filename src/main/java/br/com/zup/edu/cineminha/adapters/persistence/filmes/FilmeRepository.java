package br.com.zup.edu.cineminha.adapters.persistence.filmes;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.edu.cineminha.domain.filmes.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {

}
