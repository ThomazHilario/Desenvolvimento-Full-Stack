/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastropoo.model;

/**
 *
 * @author Thomaz Alves
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PessoaFisicaRepo {
    private ArrayList<PessoaFisica> pessoaFisicas = new ArrayList<>();

    public void inserir(PessoaFisica pessoaFisica){
        pessoaFisicas.add(pessoaFisica);
    }

    public void alterar(int id, PessoaFisica pessoaFisica){
        for(int i = 0; i < pessoaFisicas.size(); i++){
            if(pessoaFisicas.get(i).getId() == id){
                pessoaFisicas.set(i, pessoaFisica);
                break;
            }
        }
    }

    public void excluir(int id){
        for(int i = 0; i < pessoaFisicas.size(); i++){
            if(pessoaFisicas.get(i).getId() == id){
                pessoaFisicas.remove(i);
                break;
            }
        }
    }

    public PessoaFisica obter(int id) {
        for (PessoaFisica pessoa : pessoaFisicas) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null;
    }

    public ArrayList<PessoaFisica> obterTodos(){
        return pessoaFisicas;
    }

    public void persistir(String preFixo){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./" + preFixo + "fisica"))) {
            out.writeObject(pessoaFisicas);
        } catch (IOException e) {
            // Lançar uma nova exceção com uma mensagem personalizada
            
            System.err.println("Erro ao persistir os dados: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void recuperar(String preFixo) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("./"+ preFixo + "fisica"))) {
            Object obj = in.readObject();
            if (obj instanceof ArrayList<?>) {
                pessoaFisicas = (ArrayList<PessoaFisica>) obj;
            } else {
                throw new IOException("Arquivo não contém uma lista de pessoas físicas");
            }
        } catch(IOException e){
            System.err.println(e.getMessage());
        } catch(ClassNotFoundException e){
           System.err.println(e.getMessage());
        }
    }


}
