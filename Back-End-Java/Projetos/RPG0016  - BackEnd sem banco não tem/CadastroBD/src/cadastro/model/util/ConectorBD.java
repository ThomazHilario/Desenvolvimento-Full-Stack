/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Thomaz Alves
 */
public class ConectorBD {
    
    public String url = "jdbc:sqlserver://localhost:1433;databaseName=loja;user=loja;password=loja;encrypt=true;trustServerCertificate=true;";
    
    public Connection getConnection()throws SQLException{
         return DriverManager.getConnection(this.url);
    }
    
    public PreparedStatement getPrepared(Connection conn, String sql) throws SQLException{
        return conn.prepareStatement(sql);
    }
     
    public ResultSet getResult(PreparedStatement ps) throws SQLException{
        return ps.executeQuery();
    }
    
    public static void close(PreparedStatement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                System.err.print(e);
            }
        }
    }
    
    public static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
               System.err.print(e);
            }
        }
    }
    
    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
               System.err.print(e);
            }
        }
    }
}
