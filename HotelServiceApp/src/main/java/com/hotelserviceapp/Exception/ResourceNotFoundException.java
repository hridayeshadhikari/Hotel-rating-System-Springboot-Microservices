package com.hotelserviceapp.Exception;

import java.security.PublicKey;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String s){
        super(s);
    }

    public ResourceNotFoundException(){
        super("Resource not found !");
    }

}
