package com.cadastro.cadastro.exceptions;

public class AlreadyExistsCompany extends RuntimeException{
    public AlreadyExistsCompany(String msg){
        super(msg);
    }
}
