package br.com.fundatec.pessoa.controller;

import br.com.fundatec.pessoa.domain.Pessoa;
import br.com.fundatec.pessoa.service.PessoaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll() {
        List<Pessoa> resultado = pessoaService.findAll();

        return new ResponseEntity(resultado, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa) {
        Pessoa pessoaSalva = pessoaService.save(pessoa);
        return new ResponseEntity(pessoaSalva, HttpStatus.OK);
    }
}
