/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrobd.model;

/**
 *
 * @author Thomaz Alves
 */
public class Pessoa {
    private int id;
    private String nome;
    private String logradouro;
    private String cidade;
    private String estado;
    private String telefone;
    private String email;
    
    // Construtor padrao
    public Pessoa(){}
    
    // Construtor
    public Pessoa(int id, String nome, String logradouro, String cidade, String estado, String telefone, String email){
        this.id = id;
        this.nome = nome;
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
        this.email = email;
    }
    
    // metodo exibir
    public void exibir(){
        System.out.print("id:" + this.id + "\n");
        System.out.print("Nome:" + this.nome + "\n");
        System.out.print("logradouro" + this.logradouro + "\n");
        System.out.print("Cidade:" + this.cidade + "\n");
        System.out.print("Estado:" + this.estado + "\n");
        System.out.print("telefone:" + this.telefone + "\n");
        System.out.print("Email:" + this.email + "\n");
    }
}
