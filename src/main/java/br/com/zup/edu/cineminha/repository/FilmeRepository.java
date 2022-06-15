package br.com.zup.edu.cineminha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.edu.cineminha.model.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {

}
