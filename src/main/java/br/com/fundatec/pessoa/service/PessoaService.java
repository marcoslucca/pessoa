package br.com.fundatec.pessoa.service;

import br.com.fundatec.pessoa.domain.Pessoa;
import br.com.fundatec.pessoa.repository.PessoaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public Pessoa save(Pessoa pessoa) {
        return pessoaRepository.saveAndFlush(pessoa);
    }

}
