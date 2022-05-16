package br.com.zup.edu.cineminha.repository;

import br.com.zup.edu.cineminha.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaRepository extends JpaRepository<Sala, Long> {
}