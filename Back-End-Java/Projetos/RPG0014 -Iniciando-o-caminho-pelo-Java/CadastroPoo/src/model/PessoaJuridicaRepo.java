package model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
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
}
