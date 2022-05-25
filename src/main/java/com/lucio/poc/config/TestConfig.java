package com.lucio.poc.config;

import com.lucio.poc.entities.Pessoa;
import com.lucio.poc.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import java.util.Arrays;

//@Configuration
//@Profile("test")
//public class TestConfig implements CommandLineRunner {
//
//    @Autowired
//    private PessoaRepository pessoaRepository;
//
//
//    @Override
//    public void run(String... args) throws Exception {
//        Pessoa p1 = new Pessoa(null, "Jimi", "Hendrix","27/11/1942");
//        Pessoa p2 = new Pessoa(null, "Nick", "Johnston","18/06/1987");
//        pessoaRepository.saveAll(Arrays.asList(p1, p2));
//    }
//}

//Exception

//