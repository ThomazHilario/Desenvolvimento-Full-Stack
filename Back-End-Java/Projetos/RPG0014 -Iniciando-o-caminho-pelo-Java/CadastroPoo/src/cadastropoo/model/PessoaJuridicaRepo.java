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

public class PessoaJuridicaRepo {
    private ArrayList<PessoaJuridica> pessoasJuridicas = new ArrayList<>();

    // incluir
    public void incluir(PessoaJuridica pessoaJuridica){
        pessoasJuridicas.add(pessoaJuridica);
    }

    // Alterar
    public void alterar(int id, PessoaJuridica pessoaJuridica){
        for(int i = 0; i < pessoasJuridicas.size(); i++){
            if(pessoasJuridicas.get(i).getId() == id){
                pessoasJuridicas.set(i, pessoaJuridica);
                break;
            }
        }
    }

    // Excluir
    public void excluir(int id){
        for(int i = 0; i < pessoasJuridicas.size(); i++){
            if(pessoasJuridicas.get(i).getId() == id){
                pessoasJuridicas.remove(i);
                break;
            }
        }
    }

    // Obter uma pessoa
    public PessoaJuridica obter(int id){
        for(PessoaJuridica pessoa : pessoasJuridicas){
            if(pessoa.getId() == id){
                return pessoa;
            }
        }
        return null;
    }

    // Obter todos
    public ArrayList<PessoaJuridica> obterTodos(){
        return pessoasJuridicas;
    }

    // Persistir dados
    public void persistir(String preFixo) {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./" + preFixo + "juridica"))){
            if(preFixo != ""){
                out.writeObject(pessoasJuridicas);
            }else{
                throw new IOException("Erro ao persistir os dados");
            }
            
        } catch(IOException e){
            System.err.println(e.getMessage());
        }
    }

    // Recuperar dados
    @SuppressWarnings("unchecked")
    public void recuperar(String preFixo) {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("./" + preFixo + "juridica"))){
            Object obj = in.readObject();
            if(obj instanceof ArrayList<?>){
                pessoasJuridicas = (ArrayList<PessoaJuridica>) obj;
            } else{
                throw new IOException("Não foi possivel encontrar o arquivo.");
            }
        }catch(IOException e){
            System.err.println(e.getMessage());
        } catch(ClassNotFoundException e){
            System.err.println(e.getMessage());
        }
    }
}
