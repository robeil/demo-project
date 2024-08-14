package com.robeil.demoproject.exception;

public class MyCustomException extends RuntimeException{
    public MyCustomException(String message){
        super(message);
    }
}

