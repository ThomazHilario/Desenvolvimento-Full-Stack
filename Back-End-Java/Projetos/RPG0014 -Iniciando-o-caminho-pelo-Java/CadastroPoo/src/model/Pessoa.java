package model;

public class Pessoa {
    // atributos
    private Integer id;
    private String nome;

    // Constructor
    Pessoa(Integer id, String nome){
        this.id = id;
        this.nome = nome;
    }


    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
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
