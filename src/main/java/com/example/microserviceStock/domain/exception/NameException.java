package com.example.microserviceStock.domain.exception;

public class NameException extends RuntimeException{
    public NameException(String message){
        super(message);
    }
}
