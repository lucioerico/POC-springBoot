package com.lucio.poc.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id){
        super("Houve um erro ao consultar banco de dados. ERR001 ");
    }

}
//    public ResourceNotFoundException(Object id){
//        super("Houve um erro ao consultar banco de dados. Id " + id);