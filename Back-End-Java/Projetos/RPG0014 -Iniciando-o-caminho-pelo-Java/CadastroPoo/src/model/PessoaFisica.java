package model;

public class PessoaFisica extends Pessoa{
    // Atributos
    private String cpf;
    private int idade;

    // Constructor
    public PessoaFisica(String nome, int id, String cpf, int idade){
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

    public void setIdade(int idade){
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
