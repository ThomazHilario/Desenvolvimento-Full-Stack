package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

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
        for(PessoaJuridica pessoa : pessoasJuridicas){
            if(pessoa.getId() == id){
                pessoasJuridicas.remove(id);
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
    public void persistir(String nome_do_arquivo) throws IOException{
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nome_do_arquivo))){
            out.writeObject(pessoasJuridicas);
        }
    }

    // Recuperar dados
    public void recuperar(String nome_do_arquivo) throws IOException, ClassNotFoundException{
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(nome_do_arquivo))){
            Object obj = in.readObject();
            if(obj instanceof ArrayList<?>){
                pessoasJuridicas = (ArrayList<PessoaJuridica>) Arrays.asList(((PessoaJuridica[]) obj));
            } else{
                throw new IOException("Não foi possivel encontrar o arquivo.");
            }
        }
    }
}
