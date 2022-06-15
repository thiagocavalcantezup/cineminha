package br.com.zup.edu.cineminha.application.filmes;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.edu.cineminha.domain.filmes.CadastraNovoFilme;
import br.com.zup.edu.cineminha.domain.filmes.Filme;

@RestController
@RequestMapping("/api/filmes")
public class FilmeController {

    private final CadastraNovoFilme service;

    public FilmeController(CadastraNovoFilme service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> cadastra(@RequestBody @Valid NovoFilmeRequest request,
                                      UriComponentsBuilder uriBuilder) {
        Filme filme = service.salva(request);

        URI location = uriBuilder.path("/api/filmes/{id}").buildAndExpand(filme.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
