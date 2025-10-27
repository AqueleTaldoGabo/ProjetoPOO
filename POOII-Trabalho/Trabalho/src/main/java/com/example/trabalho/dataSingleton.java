package com.example.trabalho;

public class dataSingleton {
    private static final dataSingleton instance = new dataSingleton();

    private int pote;
    private String nome;
    private String tipo;

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

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getTipo(){
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
}
