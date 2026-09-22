package com.prestiger.demobackend.exceptions;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(){
        super();
    }
    public UserNotFoundException(String message){
        super(message);
    }
}
