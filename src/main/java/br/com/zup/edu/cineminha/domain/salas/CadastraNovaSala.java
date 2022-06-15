package br.com.zup.edu.cineminha.domain.salas;

import org.springframework.stereotype.Service;

@Service
public class CadastraNovaSala {

    private final CadastraNovaSalaRepository repository;

    public CadastraNovaSala(CadastraNovaSalaRepository repository) {
        this.repository = repository;
    }

    public Sala criaNovaSalaPelo(String nome) {
        return repository.salva(new Sala(nome));
    }

}
