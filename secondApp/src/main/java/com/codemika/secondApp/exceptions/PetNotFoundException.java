package com.codemika.secondapp.exceptions;

public class PetNotFoundException extends RuntimeException{
    public PetNotFoundException(Long id) {
        super("Couldn`t find pet with id= " +  id);
    }
}
