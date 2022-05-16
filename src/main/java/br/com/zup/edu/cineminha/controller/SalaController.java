package br.com.zup.edu.cineminha.controller;

import br.com.zup.edu.cineminha.controller.input.NovaSalaRequest;
import br.com.zup.edu.cineminha.model.Sala;
import br.com.zup.edu.cineminha.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/salas")
public class SalaController {


    @Autowired
    private SalaRepository repository;

    @PostMapping
    public ResponseEntity<?> cadastra(@RequestBody @Valid NovaSalaRequest request,
                                      UriComponentsBuilder uriBuilder) {

        var sala = repository.save(new Sala(request.getNome()));

        var location = uriBuilder.path("/api/salas/{id}")
                .buildAndExpand(sala.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

}
