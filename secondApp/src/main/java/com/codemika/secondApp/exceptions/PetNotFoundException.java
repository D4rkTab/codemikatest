package com.codemika.secondApp.exceptions;

public class PetNotFoundException extends RuntimeException{
    public PetNotFoundException(Long id) {
        super("Couldn`t find pet with id= " +  id);
    }
}
