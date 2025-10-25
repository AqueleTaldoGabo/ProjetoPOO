package com.example.trabalho;

public class dataSingleton {
    private static final dataSingleton instance = new dataSingleton();

    private int pote;

    private dataSingleton(){}

    public static dataSingleton getInstance(){
        return instance;
    }

    public int getPote(){
        return pote;
    }
    public void setPote(int pote){
        this.pote = pote;
    }
}
