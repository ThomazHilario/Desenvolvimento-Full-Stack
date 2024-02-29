package model;

import java.io.Serializable;

public class Pessoa implements Serializable{
    // atributos
    private int id;
    private String nome;

    //Construtor padrao
    public Pessoa(){
        this.nome = "";
        this.id = 0;
    }

    // Constructor
    Pessoa(int id, String nome){
        this.id = id;
        this.nome = nome;
    }


    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void setName(String nome){
        this.nome = nome;
    }

    public String getName(){
        return this.nome;
    }

    public void exibir(){
        System.out.println("nome: " + getName());
        System.out.println("Id: " + getId());
    }
}
