package com.lucio.poc.controller;
import com.lucio.poc.dto.PessoaDto;
import com.lucio.poc.entities.Pessoa;
import com.lucio.poc.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {
    @Autowired
    private PessoaService service;

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<PessoaDto>> findAll() {
        List<Pessoa> list = service.findAll();
        List<PessoaDto> listDto = list.stream().map(x -> new PessoaDto(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<PessoaDto>> findById(@PathVariable Long id){
        List<Pessoa> list = (List<Pessoa>) service.findById(id);
        List<PessoaDto> listDto = list.stream().map(x -> new PessoaDto(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

//    @GetMapping(value = "/{id}")
//    public ResponseEntity<Pessoa> findById(@PathVariable Long id){
//        Pessoa obj = service.findById(id);
//        return ResponseEntity.ok().body(obj);
//    }

    @PostMapping
    public ResponseEntity<Pessoa> insert(@RequestBody Pessoa obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    // string ou void
    public ResponseEntity<String> delete (@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok("Sucesso");
//        return ResponseEntity.noContent().build();
    }
    @PutMapping (value ="/{id}")
    public ResponseEntity<Pessoa> update(@PathVariable Long id, @RequestBody Pessoa obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

//
//
//    @PostMapping
//    public ResponseEntity<Pessoa> insert(@RequestBody Pessoa obj){
//        obj = service.insert(obj);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//                .buildAndExpand(obj.getId()).toUri();
//        return ResponseEntity.created(uri).body(obj);
//    }
//
//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<Void> delete (@PathVariable Long id){
//        service.delete(id);
//        return ResponseEntity.noContent().build();
//
//    }
//    @PutMapping (value ="/{id}")
//    public ResponseEntity<Pessoa> update(@PathVariable Long id, @RequestBody Pessoa obj){
//        obj = service.update(id, obj);
//        return ResponseEntity.ok().body(obj);
//    }
}
