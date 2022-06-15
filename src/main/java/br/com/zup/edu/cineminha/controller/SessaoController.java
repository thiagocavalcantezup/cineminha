package br.com.zup.edu.cineminha.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.edu.cineminha.adapters.persistence.SalaRepository;
import br.com.zup.edu.cineminha.controller.input.NovaSessaoRequest;
import br.com.zup.edu.cineminha.repository.FilmeRepository;
import br.com.zup.edu.cineminha.repository.SessaoRepository;

@RestController
@RequestMapping("/api/sessoes")
public class SessaoController {

    private final SessaoRepository repository;
    private final SalaRepository salaRepository;
    private final FilmeRepository filmeRepository;

    public SessaoController(SessaoRepository repository, SalaRepository salaRepository,
                            FilmeRepository filmeRepository) {
        this.repository = repository;
        this.salaRepository = salaRepository;
        this.filmeRepository = filmeRepository;
    }

    @PostMapping
    public ResponseEntity<?> cadastra(@RequestBody @Valid NovaSessaoRequest request,
                                      UriComponentsBuilder uriBuilder) {
        var sessao = repository.save(request.toModel(salaRepository, filmeRepository));

        var location = uriBuilder.path("/api/sessoes/{id}").buildAndExpand(sessao.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
