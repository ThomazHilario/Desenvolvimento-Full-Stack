/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroclient;

import javax.swing.JDialog;
import javax.swing.JTextArea;

public class SaidaFrame extends JDialog {

    public JTextArea texto;

    public SaidaFrame() {
        // Configurações básicas do diálogo
        setBounds(100, 100, 400, 300); // Definindo as dimensões da janela
        setModal(false); // Definindo o status modal como false
        setTitle("Saída"); // Título da janela

        // Criando a área de texto
        texto = new JTextArea();
        texto.setEditable(false); // Tornando o JTextArea somente de leitura

        // Adicionando a área de texto ao diálogo
        getContentPane().add(texto);
    }
}
