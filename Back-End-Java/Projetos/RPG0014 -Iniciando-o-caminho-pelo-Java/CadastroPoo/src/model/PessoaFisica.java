package model;

import java.io.Serializable;

public class PessoaFisica extends Pessoa implements Serializable{
    // Atributos
    private String cpf;
    private Integer idade;

    // Constructor
    PessoaFisica(String nome, Integer id, String cpf, Integer idade){
        super(id, nome);

        this.cpf = cpf;
        this.idade = idade;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getCpf(){
        return this.cpf;
    }

    public void setIdade(Integer idade){
        this.idade = idade;
    }

    public Integer getIdade(){
        return this.idade;
    }

    @Override
    public void exibir() {
        System.out.println("Nome: " + getName());
        System.out.println("Id: " + getId());
        System.out.println("Idade: " + getIdade());
        System.out.println("Cpf: " + getCpf());
    }
}
