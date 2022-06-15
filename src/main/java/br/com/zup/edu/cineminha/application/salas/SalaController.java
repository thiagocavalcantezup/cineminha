package br.com.zup.edu.cineminha.application.salas;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.edu.cineminha.domain.salas.CadastraNovaSala;
import br.com.zup.edu.cineminha.domain.salas.Sala;

@RestController
@RequestMapping("/api/salas")
public class SalaController {

    private final CadastraNovaSala service;

    public SalaController(CadastraNovaSala service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> cadastra(@RequestBody @Valid NovaSalaRequest request,
                                      UriComponentsBuilder uriBuilder) {
        Sala sala = service.criaNovaSalaPelo(request.getNome());

        URI location = uriBuilder.path("/api/salas/{id}").buildAndExpand(sala.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
