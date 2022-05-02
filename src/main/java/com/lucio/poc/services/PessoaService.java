package com.lucio.poc.services;
import com.lucio.poc.entities.Pessoa;
import com.lucio.poc.repositories.PessoaRepository;
import com.lucio.poc.services.exceptions.DatabaseException;
import com.lucio.poc.services.exceptions.ResourceNotFoundException;
import com.lucio.poc.services.exceptions.SucessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;
    public List<Pessoa> findAll(){
        return repository.findAll();
    }
    public Pessoa findById(Long id){
        Optional<Pessoa> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    public Pessoa insert(Pessoa obj){
        return repository.save(obj);
    }
    public void delete(Long id) throws SucessException {
        try{
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }
    //
    public Pessoa update(Long id, Pessoa obj){
        try {
            Pessoa entity = repository.getOne(id);
            updateData(entity, obj);
            return repository.save(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }
    private void updateData(Pessoa entity, Pessoa obj) {
        entity.setNome(obj.getNome());
        entity.setSobrenome(obj.getSobrenome());
        entity.setDataNascimento(obj.getDataNascimento());
    }
}
//
//    Caso sucesso, retornoar HttpStatus 200 e DtoDeSucesso:
//        {
//        mensagem: "sucesso"
//        }
//
//        Caso erro, disparar custom exception com HttpStatus 500 e DtoDeErro:
//        {
//        codigo: "ERR001"
//        mensagem: "Houve um erro ao consultar banco de dados"
//        }