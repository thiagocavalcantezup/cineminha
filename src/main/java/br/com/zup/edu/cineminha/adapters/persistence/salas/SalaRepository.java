package br.com.zup.edu.cineminha.adapters.persistence.salas;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.edu.cineminha.domain.salas.Sala;

public interface SalaRepository extends JpaRepository<Sala, Long> {

}
