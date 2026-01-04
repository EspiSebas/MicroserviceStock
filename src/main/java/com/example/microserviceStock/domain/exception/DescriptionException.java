package com.example.microserviceStock.domain.exception;

public class DescriptionException extends RuntimeException{
    public DescriptionException(String message){
        super(message);
    }
}
