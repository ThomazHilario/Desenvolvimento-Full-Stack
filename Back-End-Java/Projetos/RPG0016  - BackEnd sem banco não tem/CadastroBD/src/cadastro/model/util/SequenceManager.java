/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.util;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Thomaz Alves
 */
public class SequenceManager {
    // Método para obter o próximo valor de uma sequência
    public static int getValue(String sequenceName) {
        int nextValue = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = new ConectorBD().getConnection();
            ps = conn.prepareStatement("SELECT nextval(?)");
            ps.setString(1, sequenceName);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                nextValue = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.print(e);
        } finally {
            ConectorBD.close(rs);
            ConectorBD.close(ps);
            ConectorBD.close(conn);
        }
        
        return nextValue;
    }
}
