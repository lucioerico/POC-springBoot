package com.lucio.poc.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lucio.poc.entities.Pessoa;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class PessoaDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id; //inteiro - nao nulo
    @NotNull @NotEmpty
    private String nome; //  nao vazio
    @NotNull @NotEmpty
    private String sobrenome; //nao vazio
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy") @Column(name ="data_nascimento")
    private Date dataNascimento;// date

    public PessoaDto(){
    }

    public PessoaDto(Pessoa obj){
        id = obj.getId();
        nome = obj.getNome();
        sobrenome = obj.getSobrenome();
        dataNascimento = obj.getDataNascimento();
    }
}
