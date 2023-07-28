package com.codemika.firstapp.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id){
        super("Couldn`t find user " + id);
    }
}
