package model;

public class PessoaJuridica extends Pessoa{
    // Atributos
    private String cnpj;

    // Constructor
    PessoaJuridica(String nome, int id, String cnpj){
        super(id, nome);

        this.cnpj = cnpj;
    }

    public void setCnpf(String cnpj){
        this.cnpj = cnpj;
    }

    public String getCnpf(){
        return cnpj;
    }

    @Override
    public void exibir() {
        System.out.println("Nome: " + getName());
        System.out.println("Id: " + getId());
        System.out.println("Cnpj: " + getCnpf());
    }
}
