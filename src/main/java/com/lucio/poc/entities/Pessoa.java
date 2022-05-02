package com.lucio.poc.entities;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
@Entity
@Getter
@Setter
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //inteiro - nao nulo
    @NotNull @NotEmpty @Column(length = 30)
    private String nome; //  nao vazio
    @NotNull @NotEmpty @Column(length = 60)
    private String sobrenome; //nao vazio

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy") @Column(name ="data_nascimento")
    private Date dataNascimento;// date

    public Pessoa(){
    }

    public Pessoa (Long id, String nome, String sobrenome, Date dataNascimento){
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return id.equals(pessoa.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}

// https://www.youtube.com/watch?v=HU7bfKG8nV4