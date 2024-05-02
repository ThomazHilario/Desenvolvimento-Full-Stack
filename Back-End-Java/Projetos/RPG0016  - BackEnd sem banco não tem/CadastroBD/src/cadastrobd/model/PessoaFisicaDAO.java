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
public class PessoaFisicaDAO extends PessoaFisica{
    // incluindo pessoa fisica
    public void incluir(int id, String nome, String cidade, String estado, String logradouro, String telefone, String email, String cpf) throws SQLException{
        try{
            // instanciando a classe
           ConectorBD conectorBD = new ConectorBD();
           
            try ( 
                Connection conn = conectorBD.getConnection(); 
                    
                PreparedStatement psPessoa = conectorBD.getPrepared(conn, "INSERT INTO Pessoa (idPessoa, nome, cidade, estado, logradouro, telefone, email) VALUES (?, ?, ?, ?, ?, ?, ?)");
                PreparedStatement psPessoaFisica = conectorBD.getPrepared(conn, "INSERT INTO PessoaFisica (idPessoa, cpf) VALUES (?, ?)");) {
                psPessoa.setInt(1, id);
              
                
                    // Valores de pessoa
                    psPessoa.setInt(1, id);
                    psPessoa.setString(2, nome);
                    psPessoa.setString(3, cidade);
                    psPessoa.setString(4, estado);
                    psPessoa.setString(5, logradouro);
                    psPessoa.setString(6, telefone);
                    psPessoa.setString(7, email);
                    psPessoa.executeUpdate();
                    
                    // valores de pessoa Fisica
                    psPessoaFisica.setInt(1, id);
                    psPessoaFisica.setString(2,cpf);
                    psPessoaFisica.executeUpdate();
                    
                    // mostrando dados
                    PessoaFisica pessoaFisica = new PessoaFisica(id, nome, logradouro, cidade, estado, telefone, email, cpf);
                    
                    System.out.print("""
                                     ============================
                                     """);
                    pessoaFisica.exibir();
                    System.out.print("============================");
                
                     
                
       
            }
        }catch(SQLException e){
            
            System.err.print("""
                             Ja existe uma pessoa com este id
                             """);
        }
    }
   
    // Alterar valores de pessoa
    public void alterar(int id, String nome,String cidade, String estado,  String logradouro,
    String telefone, String email, String cpf) throws SQLException{
        try{
            // instanciando calsse
            ConectorBD conectorBD = new ConectorBD();
            
            // iniciando conexao
            Connection conn = conectorBD.getConnection();
            
            // instrucao sql
            PreparedStatement ps = conectorBD.getPrepared(conn,
                    "UPDATE Pessoa SET nome = ?, logradouro = ?, cidade = ?, estado = ?, telefone = ?, email = ? WHERE idPessoa = ?"
            );
            PreparedStatement psPessoaFisica = conectorBD.getPrepared(conn, "UPDATE PessoaFisica SET cpf = ? WHERE idPessoa = ?");
            
            
            // Passando parametros
            ps.setString(1, nome);
            ps.setString(2, logradouro);
            ps.setString(3, cidade);
            ps.setString(4, estado);
            ps.setString(5, telefone);
            ps.setString(6, email);
            ps.setInt(7, id);
            
            psPessoaFisica.setString(1, cpf);
            psPessoaFisica.setInt(2, id);
            
            // executando codigos
            ps.executeUpdate();
            psPessoaFisica.executeUpdate();
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    
    // excluir pessoa
    public void excluir(int id)throws SQLException{
        try{
            // instanciar classe
            ConectorBD conectorBD = new ConectorBD();
            
            // iniciando conexao
            Connection conn = conectorBD.getConnection();
            
            // instrucao sql
            PreparedStatement psJuridica = conectorBD.getPrepared(conn, "DELETE FROM PessoasJuridicas WHERE idPessoa = ?");
            PreparedStatement psFisica = conectorBD.getPrepared(conn, "DELETE FROM PessoaFisica WHERE idPessoa = ?");
            PreparedStatement psPessoa = conectorBD.getPrepared(conn, "DELETE FROM Pessoa WHERE idPessoa = ?");
            
            // Passando o parametro do id
            psJuridica.setInt(1, id);
            psFisica.setInt(1, id);
            psPessoa.setInt(1, id);
            
            // executando
            psJuridica.executeUpdate();
            psFisica.executeUpdate();
            psPessoa.executeUpdate();
            
            
            System.out.println("Pessoa Fisica excluida!");
            
        }catch(SQLException e){
            System.err.print(e);
        }
    }
    
    // Retornando uma peessoa fisica
    public boolean getPessoa(int id) throws SQLException{
        try{
            // Criando uma variavel de pessoa fisica
            PessoaFisica pessoaFisica = null;

            // instanciando banco de dados
            ConectorBD conectorBD = new ConectorBD();

            // iniciando conexao com o banco de dados        
            Connection conn = conectorBD.getConnection();

            // Especificando o que buscar com o statement
            PreparedStatement ps = conectorBD.getPrepared(conn, "SELECT * FROM Pessoa JOIN PessoaFisica ON Pessoa.idPessoa = PessoaFisica.idPessoa WHERE Pessoa.idPessoa = ?");
            ps.setInt(1, id);

            // resultado
            ResultSet rs = conectorBD.getResult(ps);

            if(rs.next()){
                // Instanciando pessoa fisica
                pessoaFisica = new PessoaFisica(rs.getInt("idPessoa"), rs.getString("nome"), rs.getString("logradouro"), rs.getString("cidade"), rs.getString("estado"), rs.getString("telefone"), rs.getString("email"), rs.getString("cpf"));
                pessoaFisica.exibir();
                ConectorBD.close(conn);
                ConectorBD.close(ps);
                ConectorBD.close(rs);
                return true;
            }else{
                System.out.println("Está pessoa não existe");
                ConectorBD.close(conn);
                ConectorBD.close(ps);
                ConectorBD.close(rs);
                return false;
            }

            
        }catch(SQLException e){
            System.err.println(e);
        }
        return false;
    }
    
    // Retornando todas as pessoa fisicas
    public void getPessoas() throws SQLException{        
        // instanciando conexao com o banco de dados
        ConectorBD conectorBD = new ConectorBD();
        
        try{
            // iniciando conexao
            Connection conn = conectorBD.getConnection();

            // Statement
            PreparedStatement ps = conectorBD.getPrepared(conn, "SELECT * FROM Pessoa JOIN PessoaFisica ON Pessoa.idPessoa = PessoaFisica.idPessoa");
            
            ResultSet rs = conectorBD.getResult(ps);
            
            while(rs.next()){
                PessoaFisica pf = new PessoaFisica(rs.getInt("idPessoa"), rs.getString("nome"), 
                rs.getString("logradouro"), rs.getString("cidade"), rs.getString("estado"), rs.getString("telefone"), rs.getString("email"), rs.getString("cpf"));
                
                pf.exibir();
                System.out.println("======================");
            }
        }catch(SQLException e){
            System.err.print(e);
        }
    }
}
