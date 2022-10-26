package com.example.wishlistproject.Repository.Connection;

public class DbConnectionStringException extends Exception{
    public DbConnectionStringException(){
        super("No connection string defined");
    }
}
