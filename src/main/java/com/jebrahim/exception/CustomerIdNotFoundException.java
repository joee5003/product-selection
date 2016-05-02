package com.jebrahim.exception;

public class CustomerIdNotFoundException extends Exception
{
    public CustomerIdNotFoundException(String pUserId) {
        super( "User Id: " + pUserId + " not found" );
    }
}
