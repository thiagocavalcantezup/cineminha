package br.com.zup.edu.cineminha.adapters.persistence.sessoes;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.edu.cineminha.domain.sessoes.Sessao;

public interface SessaoRepository extends JpaRepository<Sessao, Long> {

}
