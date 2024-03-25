/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastropoo.model;

/**
 *
 * @author Thomaz Alves
 */
public class PessoaJuridica extends Pessoa{
    // Atributos
    private String cnpj;

    // Constructor
    public PessoaJuridica(String nome, int id, String cnpj){
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
