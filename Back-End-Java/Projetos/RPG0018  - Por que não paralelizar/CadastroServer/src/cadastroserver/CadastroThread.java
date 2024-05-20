/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroserver;

import controller.ProdutoJpaController;
import controller.UsuarioJpaController;
import controller.MovimentosJpaController;
import controller.PessoaJpaController;
import cadastroserver.CadastroServer;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import model.Movimentos;
import model.Produto;
import model.Usuario;

/**
 *
 * @author Thomaz Alves
 */
public class CadastroThread extends Thread{
    private ProdutoJpaController ctrl;
    private UsuarioJpaController ctrlUsu;
    private MovimentosJpaController ctrlMov;
    private PessoaJpaController ctrlPessoa;
    private Socket s1;
    private volatile boolean isRunning = true;

    public CadastroThread(ProdutoJpaController ctrl, UsuarioJpaController ctrlUsu, MovimentosJpaController ctrlMov, PessoaJpaController ctrlPessoa, Socket s1) {
        this.ctrl = ctrl;
        this.ctrlUsu = ctrlUsu;
        this.ctrlMov = ctrlMov;
        this.ctrlPessoa = ctrlPessoa;
        this.s1 = s1;
    }

    public void run() {
        try (
            ObjectOutputStream out = new ObjectOutputStream(s1.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(s1.getInputStream())
        ) {
            // Obter login e senha
            String login = (String) in.readObject();
            String senha = (String) in.readObject();
            
            // instanciando o cadastroServer
            CadastroServer cs = new CadastroServer();

            // Verificar login
            Usuario usuario = ctrlUsu.findUsuario(login, senha);

            if(usuario != null){
                out.writeObject(true);
                
            }
            
            if(usuario == null){
                out.writeObject(false);
                s1.close();
                return;
            }
            
            // Loop de resposta
            String comando;
            do {
                comando = (String) in.readObject();
                switch (comando) {
                    case "L":
                        // Enviar conjunto de produtos
                        enviarProdutos(out);
                        break;
                    case "E":
                        // Entrada ou saída de produtos
                        String tipo = comando;

                        int idUsuario = (int) in.readObject();

                        int idPessoa = (int) in.readObject();

                        int idProduto = (int) in.readObject();

                        int quantidade = (int) in.readObject();

                        String precoUnitario = (String) in.readObject();

                        BigDecimal precoUnitarioBigDecimal = new BigDecimal(precoUnitario);

                        realizarMovimento(tipo, idUsuario, idPessoa, idProduto, quantidade, precoUnitarioBigDecimal);
                        break;
                    case "S":
                        // Entrada ou saída de produtos
                        String tipoSaida = comando;

                        int idUsuarioS = (int) in.readObject();

                        int idPessoaS = (int) in.readObject();

                        int idProdutoS = (int) in.readObject();

                        int quantidadeS = (int) in.readObject();

                        String precoUnitarioS = (String) in.readObject();

                        BigDecimal precoUnitarioBigDecimalS = new BigDecimal(precoUnitarioS);

                        realizarMovimento(tipoSaida, idUsuarioS, idPessoaS, idProdutoS, quantidadeS, precoUnitarioBigDecimalS);
                        break;

                    case "X":
                        isRunning = false;
                        cs.stopRunning();
                        break;
                    default:
                        System.out.println("Comando inválido: " + comando);
                }
            } while (!comando.equalsIgnoreCase("x"));

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void enviarProdutos(ObjectOutputStream out) throws IOException {
        try {
            // Obter a lista de produtos do controlador
            List<Produto> produtos = ctrl.findProdutos();

            out.writeObject(produtos);
            out.flush();
        } catch (Exception e) {
            // Em caso de erro, enviar uma mensagem de erro ao cliente
            out.writeObject("Erro ao obter a lista de produtos: " + e.getMessage());
        }
    }
    
    private void realizarMovimento(String tipo, int idUsuario, int idPessoa, int idProduto, int quantidade, BigDecimal numeroBigDecimal) throws IOException, ClassNotFoundException{
        try {
        // Cria um novo objeto Movimentos
        Movimentos movimento = new Movimentos();
        
        // id Movimento
        movimento.setIdMovimento(ctrlMov.findMovimentos().size() + 1);
        
        // idUsuario
        movimento.setIdUsuario(idUsuario);
        
        // Define o tipo de movimento
        movimento.setTipo(tipo.toUpperCase());
        
        // Busca a pessoa pelo ID e a associa ao movimento
        movimento.setIdPessoa(ctrlPessoa.findPessoa(idPessoa));
        
        // Busca o produto pelo ID e a associa ao movimento
        movimento.setIdProduto(ctrl.findProduto(idProduto));
        
        // Define a quantidade do movimento
        movimento.setQuantidade(quantidade);
        
        // Define o preço unitário do movimento
        movimento.setPrecoUnitario(numeroBigDecimal);
        
        ctrlMov.create(movimento);
    } catch (Exception e) {
        // Em caso de erro, envia uma mensagem de erro ao cliente
        System.err.println(e);
    }
            
        
    }
    
    public void stopRunning() {
        isRunning = false;
        try {
            if (s1 != null && !s1.isClosed()) {
                s1.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
