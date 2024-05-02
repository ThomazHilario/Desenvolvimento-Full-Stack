/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrobd.model;

import cadastro.model.util.ConectorBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Thomaz Alves
 */
public class PessoaJuridicaDAO extends PessoaJuridica{
    // incluir pessoa juridica
    public void incluir(int id, String cnpj) throws SQLException{
        try{
            // instanciando classe
            ConectorBD conectorBD = new ConectorBD();
            
            // iniciando Conexao
            Connection conn = conectorBD.getConnection();
            
            // instrucao SQL
            PreparedStatement ps = conectorBD.getPrepared(conn, "SELECT * FROM Pessoa where Pessoa.idPessoa = ?");
            PreparedStatement psPessoaJuridica = conectorBD.getPrepared(conn, "INSERT INTO PessoasJuridicas (idPessoa, cnpj) VALUES (?, ?)");
            
            // Passando parametro
            ps.setInt(1, id);
            
            // resultado
            ResultSet rs = conectorBD.getResult(ps);
            
            if(rs.next()){
                PessoaJuridica pj = new PessoaJuridica(id, rs.getString("nome"), rs.getString("logradouro"), rs.getString("cidade"), 
                rs.getString("estado"),rs.getString("telefone"), rs.getString("email"), cnpj);
                
                psPessoaJuridica.setInt(1, id);
                psPessoaJuridica.setString(2, cnpj);
                psPessoaJuridica.executeUpdate();
                
                
                System.out.println("""
                                   ===========================
                                   """);
                pj.exibir();
                System.out.println("""
                                   ===========================
                                   """);
            }
            
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    
    // alterando informacoes
    public void alterar(int id, String nome, String cidade, String estado, String logradouro,
        String telefone, String email, String cnpj) throws SQLException{
        try{
            // instanciando classe
            ConectorBD conectorBD =new ConectorBD();
            
            // iniciando conexao
            Connection conn = conectorBD.getConnection();
            
            // instrucao SQL
            PreparedStatement ps = conectorBD.getPrepared(conn, "UPDATE Pessoa SET nome = ?, logradouro = ?, cidade = ?, estado = ?, telefone = ?, email = ? WHERE idPessoa = ?");
            PreparedStatement psPJ = conectorBD.getPrepared(conn, "UPDATE PessoasJuridicas SET cnpj = ? WHERE idPessoa = ?");
                
                
            ps.setString(1, nome);
            ps.setString(2, logradouro);
            ps.setString(3, cidade);
            ps.setString(4, estado);
            ps.setString(5, telefone);
            ps.setString(6, email);
            ps.setInt(7, id);

            psPJ.setString(1,cnpj);
            psPJ.setInt(2, id);

            ps.executeUpdate();
            psPJ.executeUpdate();

            System.out.println("informacoes da pessoa alterada com sucesso.");
                
            
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    
    // Excluir pessoaJuridica
    public void excluir(int id) throws SQLException{
        try{
            // instanciando classe
            ConectorBD conectorBD = new ConectorBD();
            
            // iniciando conexao
            Connection conn = conectorBD.getConnection();
            
            // Instrucao SQL
            PreparedStatement ps = conectorBD.getPrepared(conn, "DELETE FROM PessoasJuridicas WHERE idPessoa = ?");
            
            ps.setInt(1, id);
            
            ps.executeUpdate();
            
            System.out.println("Cnpj deletado com sucesso!");
        }catch(SQLException e){
            System.err.println(e);
        }
            
    }
    
    // Buscando pessoa juridica
    public boolean getPessoa(int id) throws SQLException{
        try{
            // instanciar a classe conector
            ConectorBD conectorBD = new ConectorBD();
            
            // iniciando conexao
            Connection conn = conectorBD.getConnection();
            
            // Instrucao SQL
            PreparedStatement ps = conectorBD.getPrepared(conn, "SELECT * FROM Pessoa JOIN PessoasJuridicas ON Pessoa.idPessoa = PessoasJuridicas.idPessoa WHERE Pessoa.idPessoa = ?");
            
            // passando parametros
            ps.setInt(1, id);
            
            // obtendo resultado
            ResultSet rs = conectorBD.getResult(ps);
            
            if(rs.next()){
                PessoaJuridica pj = new PessoaJuridica(id, rs.getString("nome"), rs.getString("logradouro"), 
                rs.getString("cidade"), rs.getString("estado"), rs.getString("telefone"), rs.getString("email"), rs.getString("cnpj"));
               
                pj.exibir();
                
                return true;
            } else{
                System.out.println("Está pessoa não existe");
                return false;
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        
        return false;
    }
    
    // Buscando todas as pessoas juridicas
    public void getPessoas() throws SQLException{
        try{
            // instanciando classe
            ConectorBD conectorBD = new ConectorBD();
            
            // iniciando conexao
            Connection conn = conectorBD.getConnection();
            
            // instrucao SQL
            PreparedStatement ps = conectorBD.getPrepared(conn, "SELECT * FROM Pessoa JOIN PessoasJuridicas ON Pessoa.idPessoa = PessoasJuridicas.idPessoa");
            
            // resultado
            ResultSet rs = conectorBD.getResult(ps);
            
            while(rs.next()){
                PessoaJuridica pj = new PessoaJuridica(rs.getInt("idPessoa"), rs.getString("nome"), rs.getString("logradouro"), 
                rs.getString("cidade"), rs.getString("estado"), rs.getString("telefone"), rs.getString("email"), rs.getString("cnpj"));
               
                pj.exibir();
            }
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    
}
