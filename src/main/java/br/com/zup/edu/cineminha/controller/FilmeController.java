package br.com.zup.edu.cineminha.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.edu.cineminha.controller.input.NovoFilmeRequest;
import br.com.zup.edu.cineminha.repository.FilmeRepository;

@RestController
@RequestMapping("/api/filmes")
public class FilmeController {

    private final FilmeRepository repository;

    public FilmeController(FilmeRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<?> cadastra(@RequestBody @Valid NovoFilmeRequest request,
                                      UriComponentsBuilder uriBuilder) {
        var filme = repository.save(request.toModel());

        var location = uriBuilder.path("/api/filmes/{id}").buildAndExpand(filme.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
