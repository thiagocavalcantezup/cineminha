package br.com.zup.edu.cineminha.application.sessoes;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.edu.cineminha.domain.sessoes.CadastraNovaSessao;
import br.com.zup.edu.cineminha.domain.sessoes.Sessao;

@RestController
@RequestMapping("/api/sessoes")
public class SessaoController {

    private final CadastraNovaSessao service;

    public SessaoController(CadastraNovaSessao service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> cadastra(@RequestBody @Valid NovaSessaoRequest request,
                                      UriComponentsBuilder uriBuilder) {
        Sessao sessao = service.salva(request);

        URI location = uriBuilder.path("/api/sessoes/{id}").buildAndExpand(sessao.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
