package com.example.wishlistproject.Repository.SqlContext;

public class DbConnectionStringException extends Exception{
    public DbConnectionStringException(){
        super("No connection string defined");
    }
}
