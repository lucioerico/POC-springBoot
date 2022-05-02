package com.lucio.poc.services.exceptions;

public class SucessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public SucessException(Object id){
        super("SUCESSO");
    }

}

