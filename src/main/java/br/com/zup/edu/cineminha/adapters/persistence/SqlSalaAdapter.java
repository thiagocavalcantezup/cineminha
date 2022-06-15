package br.com.zup.edu.cineminha.adapters.persistence;

import org.springframework.stereotype.Component;

import br.com.zup.edu.cineminha.domain.CadastraNovaSalaRepository;
import br.com.zup.edu.cineminha.domain.Sala;

@Component
public class SqlSalaAdapter implements CadastraNovaSalaRepository {

    private final SalaRepository repository;

    public SqlSalaAdapter(SalaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Sala salva(Sala sala) {
        return repository.save(sala);
    }

}
