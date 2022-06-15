package br.com.zup.edu.cineminha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.edu.cineminha.model.Sessao;

public interface SessaoRepository extends JpaRepository<Sessao, Long> {

}
