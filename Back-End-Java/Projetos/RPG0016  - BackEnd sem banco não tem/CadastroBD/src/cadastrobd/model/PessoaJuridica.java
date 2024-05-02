/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrobd.model;

/**
 *
 * @author Thomaz Alves
 */
public class PessoaJuridica extends Pessoa{
    private String cnpj;
    
    // Construtor padrao
    public PessoaJuridica(){}
    
    // Construtor Completo
    public PessoaJuridica(int id, String nome, String logradouro, String cidade, String estado, String telefone, String email, String cnpj){
        super(id, nome, logradouro, cidade, estado, telefone, email);
        this.cnpj = cnpj;
    }
    
    @Override
    public void exibir(){
        super.exibir();
        System.out.print(this.cnpj + "\n");
    }
}
