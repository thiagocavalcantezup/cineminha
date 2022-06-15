package br.com.zup.edu.cineminha.adapters.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.edu.cineminha.domain.Sala;

public interface SalaRepository extends JpaRepository<Sala, Long> {

}
