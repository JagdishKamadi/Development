package com.epam.exception;

public class AssociationNotFoundException extends RuntimeException{
    public AssociationNotFoundException()
    {
        super("Association not found ");

    }
}
