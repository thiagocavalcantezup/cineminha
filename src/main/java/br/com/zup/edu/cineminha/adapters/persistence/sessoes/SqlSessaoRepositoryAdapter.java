package br.com.zup.edu.cineminha.adapters.persistence.sessoes;

import org.springframework.stereotype.Repository;

import br.com.zup.edu.cineminha.domain.sessoes.CadastraNovaSessaoRepository;
import br.com.zup.edu.cineminha.domain.sessoes.Sessao;

@Repository
public class SqlSessaoRepositoryAdapter implements CadastraNovaSessaoRepository {

    private final SessaoRepository repository;

    public SqlSessaoRepositoryAdapter(SessaoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Sessao salva(Sessao sessao) {
        return repository.save(sessao);
    }

}
