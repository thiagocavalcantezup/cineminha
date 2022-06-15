package br.com.zup.edu.cineminha.application;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.edu.cineminha.domain.CadastraNovaSala;

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
        var sala = service.criaNovaSalaPelo(request.getNome());

        var location = uriBuilder.path("/api/salas/{id}").buildAndExpand(sala.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
