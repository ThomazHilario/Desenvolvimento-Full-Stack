/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastrobd;
import cadastrobd.model.*;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Thomaz Alves
 */
public class CadastroBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // instanciando classe
        PessoaFisicaDAO pf = new PessoaFisicaDAO();
        PessoaJuridicaDAO pj = new PessoaJuridicaDAO();
        
        int opcao;
        
        do{
            System.out.println("""
                               Escolha uma opcao: 
                               """);
            System.out.println("1 - Incluir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Obter");
            System.out.println("5 - ObterTodos");
            System.out.println("0 - Sair do programa");
            
            opcao = sc.nextInt();
            sc.nextLine();
            
            switch(opcao){
                case 1 -> {
                    System.out.print("""
                                     F - Pessoa Fisica | J - Pessoa Juridica
                                     """);
                    String pessoaTipo = sc.nextLine();
                    
                    if(pessoaTipo.equalsIgnoreCase("f") == true){
                        try {
                            // id
                            System.out.println("Id da pessoa que ira cadastrar:");
                            int id = sc.nextInt();
                            sc.nextLine();
                            
                            // nome
                            System.out.println("Nome da pessoa:");
                            String nome = sc.nextLine();
                            
                            // cidade
                            System.out.println("Cidade:");
                            String cidade = sc.nextLine();
                            
                            // estado
                            System.out.println("Estado:");
                            String estado = sc.nextLine();
                            
                            // logradouro
                            System.out.println("Logradouro:");
                            String logradouro = sc.nextLine();
                            
                            // telefone
                            System.out.println("Telefone:");
                            String telefone = sc.nextLine();
                            
                            // email
                            System.out.println("Email:");
                            String email = sc.nextLine();
                            
                            //cpf
                            System.out.println("CPF:");
                            String cpf = sc.nextLine();
                            
                            pf.incluir(id, nome, cidade, estado, logradouro, telefone, email, cpf);
                        } catch (SQLException ex) {
                            Logger.getLogger(CadastroBD.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else if(pessoaTipo.equalsIgnoreCase("j") == true){
                        try{
                            // id
                            System.out.println("Id da pessoa que ira incluir um cnpj");
                            int id = sc.nextInt();
                            sc.nextLine();
                            
                            //cpf
                            System.out.println("Cnpj:");
                            String cnpj = sc.nextLine();
                            
                            pj.incluir(id, cnpj);
                            
                        }catch(SQLException e){
                            System.err.print(e);
                        }
                    }
                }
                case 2 -> {
                    System.out.println("""
                                     F - Pessoa Fisica | J - Pessoa Juridica
                                     """);
                    String pessoaTipo = sc.nextLine();
                    
                    if(pessoaTipo.equalsIgnoreCase("f") == true){
                        try{
                            // id
                            System.out.println("Id da pessoa que ira editar:");
                            int id = sc.nextInt();
                            sc.nextLine();
                            
                            if(pf.getPessoa(id) == true){
                                System.out.println("Nome:");
                                String nome = sc.nextLine();
                                
                                System.out.println("Cidade");
                                String cidade = sc.nextLine();
                                
                                System.out.println("Estado:");
                                String estado = sc.nextLine();
                                
                                System.out.println("Logradouro");
                                String logradouro = sc.nextLine();
                                
                                System.out.println("Telefone:");
                                String telefone = sc.nextLine();
                                
                                System.out.println("Email:");
                                String email = sc.nextLine();
                                
                                System.out.println("CPF:");
                                String cpf = sc.nextLine();
                                
                                // Alterando dados da pessoa
                                pf.alterar(id, nome, cidade, estado, logradouro, telefone, email, cpf);
                                
                                System.out.println("Dados alterado com sucesso!");
                            }
                        }catch(SQLException e){
                            System.err.println(e);
                        }
                    }else if(pessoaTipo.equalsIgnoreCase("j")){
                        try{
                            // id
                            System.out.println("Id da pessoa que ira editar:");
                            int id = sc.nextInt();
                            sc.nextLine();
                            
                            if(pj.getPessoa(id) == true){
                                System.out.println("Nome:");
                                String nome = sc.nextLine();
                                
                                System.out.println("Cidade");
                                String cidade = sc.nextLine();
                                
                                System.out.println("Estado:");
                                String estado = sc.nextLine();
                                
                                System.out.println("Logradouro");
                                String logradouro = sc.nextLine();
                                
                                System.out.println("Telefone:");
                                String telefone = sc.nextLine();
                                
                                System.out.println("Email:");
                                String email = sc.nextLine();
                                
                                System.out.println("CNPJ:");
                                String cnpj = sc.nextLine();
                                
                                pj.alterar(id, nome, cidade, estado, logradouro, telefone, email, cnpj);
                            }
                        }catch(SQLException e){
                            System.err.print(e);
                        }
                    }
                }
                case 3 -> {
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String pessoaTipo = sc.nextLine();
                    
                    if(pessoaTipo.equalsIgnoreCase("f") == true){
                        try{
                            // id 
                            System.out.println("Digite o id da pessoa que ira deletar:");
                            int id = sc.nextInt();
                            sc.nextLine();
                            pf.excluir(id);
                        }catch(SQLException e){
                            System.err.println(e);
                        }
                    } else if(pessoaTipo.equalsIgnoreCase("j") == true){
                        try{
                            // id
                            System.out.println("Id da pessoa que ira retirar o cnpj:");
                            int id = sc.nextInt();
                            sc.nextLine();
                            
                            pj.excluir(id);
                        }catch(SQLException e){
                            System.err.println(e);
                        }
                    }
                }
                case 4 -> {
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String pessoaTipo = sc.nextLine();
                    
                    if(pessoaTipo.equalsIgnoreCase("f") == true){
                        try{
                            // id
                            System.out.println("Id da pessoa que deseja buscar");
                            int id = sc.nextInt();
                            sc.nextLine();
                        
                            pf.getPessoa(id);
                        }catch(SQLException e){
                            System.err.println(e);
                        }
                    } else if(pessoaTipo.equalsIgnoreCase("j") == true){
                        try{
                            // id
                            System.out.println("Id da pessoa que deseja buscar");
                            int id = sc.nextInt();
                            sc.nextLine();
                        
                            pj.getPessoa(id);
                        }catch(SQLException e){
                            System.err.println(e);
                        }
                    }
                }
                case 5 -> {
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String pessoaTipo = sc.nextLine();
                    
                    if(pessoaTipo.equalsIgnoreCase("f") == true){
                        try{
                            pf.getPessoas();
                        }catch(SQLException e){
                            System.err.println(e);
                        }
                    } else if(pessoaTipo.equalsIgnoreCase("j") == true){
                        try{
                            pj.getPessoas();
                        }catch(SQLException e){
                            System.err.println(e);
                        }
                    }
                }
            }
        }while(opcao != 0);
    }
    
}
