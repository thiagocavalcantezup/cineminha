package br.com.zup.edu.cineminha.domain.salas;

import java.util.Optional;

public interface EncontraSalaPorIdRepository {

    Optional<Sala> encontraPorId(Long id);

}
