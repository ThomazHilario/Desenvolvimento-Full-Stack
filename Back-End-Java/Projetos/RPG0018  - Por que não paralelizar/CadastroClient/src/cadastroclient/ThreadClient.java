/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.System.in;
import static java.lang.System.out;
import java.net.Socket;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import model.Produto;

public class ThreadClient extends Thread {

    private final ObjectOutputStream out;
    private final ObjectInputStream in;
    
    public ThreadClient(ObjectInputStream in, ObjectOutputStream out) {
        this.in = in;
        this.out = out;
    }
    
    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            boolean validate = (boolean) in.readObject();
            
            
            if(validate){
                 // Criando um JTextArea
                JTextArea textArea = new JTextArea(10, 30);

                // Criando uma JFrame para exibir o JTextArea
                JFrame frame = new JFrame("Exemplo InvokeLater");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(textArea);
                frame.pack();
                frame.setVisible(true);

                SwingUtilities.invokeLater(() -> {
                    textArea.append("Usuario Conectado \n");
                });
                
                String command;
                
                do {
                    System.out.println("Menu:");
                    System.out.println("L - Listar");
                    System.out.println("X - Finalizar");
                    System.out.println("E - Entrada");
                    System.out.println("S - Saída");
                    System.out.print("Digite o comando: ");
                    command = reader.readLine();

                    switch (command.toUpperCase()) {
                        case "L":
                            out.writeObject(command.toUpperCase());

                            Object resposta;

                            boolean continua = true;

                            while (continua) {
                                resposta = in.readObject();
                                if (resposta instanceof String) {
                                    // Se for uma String, trata-se de uma mensagem de erro ou de confirmação
                                    System.out.println((String) resposta);
                                } else if (resposta instanceof List) {
                                    // Se for uma List, trata-se da lista de produtos
                                    List<Produto> produtos = (List<Produto>) resposta;
                                    if (produtos.isEmpty()) {
                                        System.out.println("Não há produtos disponíveis.");
                                    } else {
                                        textArea.append("Lista de produtos: \n");

                                        SwingUtilities.invokeLater(() -> {
                                            for (Produto produto : produtos) {
                                                textArea.append(produto.getNome() + ":" + produto.getQuantidade() + "\n");
                                            }
                                        });
                                    }
                                } else {
                                    // Se for outro tipo de objeto, trata-se de uma resposta inesperada do servidor
                                    System.out.println("Resposta inesperada do servidor.");
                                }

                                // Verifica se deseja continuar o loop
                                continua = false; // Define continua como false para parar o loop

                            }  



                            break;
                        case "E":
                            // Envio do comando
                            out.writeObject(command.toUpperCase());

                            // Obtenção dos dados

                            System.out.print("Id do Usuario: ");
                            int idUsuario = Integer.parseInt(reader.readLine());
                            out.writeObject(idUsuario);


                            System.out.print("Id da pessoa: ");
                            int idPessoa = Integer.parseInt(reader.readLine());
                            out.writeObject(idPessoa);

                            System.out.print("Id do produto: ");
                            int idProduto = Integer.parseInt(reader.readLine());
                            out.writeObject(idProduto);

                            System.out.print("Quantidade: ");
                            int quantidade = Integer.parseInt(reader.readLine());
                            out.writeObject(quantidade);

                            System.out.print("Preco unitario: ");
                            String valorUnitario = reader.readLine();
                            out.writeObject(valorUnitario);

                            textArea.append("Movimentação de entrada realizada.");
                            break;

                        case "S":
                            // Envio do comando
                            out.writeObject(command.toUpperCase());

                            // Obtenção dos dados

                            System.out.print("Id do Usuario: ");
                            int idUsuarioS = Integer.parseInt(reader.readLine());
                            out.writeObject(idUsuarioS);


                            System.out.print("Id da pessoa: ");
                            int idPessoaS = Integer.parseInt(reader.readLine());
                            out.writeObject(idPessoaS);

                            System.out.print("Id do produto: ");
                            int idProdutoS = Integer.parseInt(reader.readLine());
                            out.writeObject(idProdutoS);

                            System.out.print("Quantidade: ");
                            int quantidadeS = Integer.parseInt(reader.readLine());
                            out.writeObject(quantidadeS);

                            System.out.print("Preco unitario: ");
                            String valorUnitarioS = reader.readLine();
                            out.writeObject(valorUnitarioS);
                            
                            textArea.append("Movimentação de saida realizada.");
                            break;
                        case "X":
                            validate = false;
                            out.writeObject(command.toUpperCase());
                            System.out.println("Finalizando...");
                            frame.setVisible(false);
                            break;
                        default:
                            System.out.println("Comando inválido.");
                    }
                } while (!command.equalsIgnoreCase("X"));
            }else{
                System.out.println("Usuario invalido");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
