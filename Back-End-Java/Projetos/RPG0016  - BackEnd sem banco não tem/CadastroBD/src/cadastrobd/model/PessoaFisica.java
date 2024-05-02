/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrobd.model;

/**
 *
 * @author Thomaz Alves
 */
public class PessoaFisica extends Pessoa{
    private String cpf;
    
    // Construtor padrao
    public PessoaFisica(){}
    
    // construtor
    public PessoaFisica(int id, String nome, String logradouro, String cidade, String estado, String telefone, String email,String cpf){
        super(id, nome, logradouro, cidade, estado, telefone, email);
        this.cpf = cpf;
    }
    
    @Override
    public void exibir(){
        super.exibir();
        System.out.print("Cpf:" + this.cpf + "\n");
    }
}
