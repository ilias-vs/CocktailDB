package project.model;

import project.model.repository.Connection;

public class Singleton {
    private static Connection instance = new Connection();

    private Singleton(){

    }
    public static Connection getInstance(){
        return instance;
    }



}
