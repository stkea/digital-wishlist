package com.example.wishlistproject.Persitence.Connection;

public class DbConnectionStringException extends Exception{
    public DbConnectionStringException(){
        super("No connection string defined");
    }
}
