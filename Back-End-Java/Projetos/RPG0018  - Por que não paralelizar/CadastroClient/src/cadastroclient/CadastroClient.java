/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastroclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import cadastroclient.ThreadClient;

/**
 *
 * @author Thomaz Alves
 */
public class CadastroClient {

    public static void main(String[] args) throws ClassNotFoundException {
        try {
            Socket socket = new Socket("localhost", 4321);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("LOGIN");
            System.out.print("Usuário: ");
            String login = reader.readLine();
            System.out.print("Senha: ");
            String senha = reader.readLine();

            out.writeObject(login);
            out.writeObject(senha);

            ThreadClient tc = new ThreadClient(in, out);
            tc.start();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
