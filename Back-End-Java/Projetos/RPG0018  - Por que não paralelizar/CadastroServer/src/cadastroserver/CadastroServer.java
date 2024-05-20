/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastroserver;

import controller.ProdutoJpaController;
import controller.UsuarioJpaController;
import controller.MovimentosJpaController;
import controller.PessoaJpaController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Thomaz Alves
 */
public class CadastroServer {
    
    public volatile boolean isRunning = true;
    
    public static void main(String[] args) {
        // Instanciar EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CadastroServerPU");
        EntityManager em = emf.createEntityManager();
        
        
        // Instanciar ProdutoJpaController e UsuarioJpaController
        ProdutoJpaController ctrl = new ProdutoJpaController(em);
        UsuarioJpaController ctrlUsu = new UsuarioJpaController(em);
        MovimentosJpaController ctrlMov = new MovimentosJpaController(em);
        PessoaJpaController ctrlPessoa = new PessoaJpaController(em);
        
        CadastroServer cs = new CadastroServer();

        try (ServerSocket serverSocket = new ServerSocket(4321)) {
            System.out.println("Servidor CadastroServer iniciado. Aguardando conexões...");

            // Loop infinito para aceitar conexões de clientes
            while (cs.isRunning == true) {
                // Aguardar requisição de conexão do cliente
                Socket socket = serverSocket.accept();
                System.out.println("Novo cliente conectado: " + socket);

                // Instanciar uma nova thread para lidar com o cliente
                CadastroThread thread = new CadastroThread(ctrl, ctrlUsu, ctrlMov, ctrlPessoa, socket);
                thread.run();
                
                if(cs.isRunning == false){
                    thread.stopRunning();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Fechar o EntityManagerFactory ao final da execução
            emf.close();
            em.close();
        }
    }
    
    public void stopRunning(){
        this.isRunning = false;
    }
}
