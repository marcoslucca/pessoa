package br.com.fundatec.pessoa.repository;

import br.com.fundatec.pessoa.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query(value = "SELECT CASE WHEN (COUNT(*) > 0) THEN true ELSE false END FROM pessoa WHERE cpf = :cpf", nativeQuery = true)
    public boolean existsByCpf(@Param("cpf") String cpf);

}
