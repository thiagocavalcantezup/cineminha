package br.com.zup.edu.cineminha.adapters.persistence.salas;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.zup.edu.cineminha.domain.salas.CadastraNovaSalaRepository;
import br.com.zup.edu.cineminha.domain.salas.EncontraSalaPorIdRepository;
import br.com.zup.edu.cineminha.domain.salas.Sala;

@Component
public class SqlSalaAdapter implements CadastraNovaSalaRepository, EncontraSalaPorIdRepository {

    private final SalaRepository repository;

    public SqlSalaAdapter(SalaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Sala salva(Sala sala) {
        return repository.save(sala);
    }

    @Override
    public Optional<Sala> encontraPorId(Long id) {
        return repository.findById(id);
    }

}
