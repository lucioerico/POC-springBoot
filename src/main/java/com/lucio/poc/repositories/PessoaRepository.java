package com.lucio.poc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lucio.poc.entities.Pessoa;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
