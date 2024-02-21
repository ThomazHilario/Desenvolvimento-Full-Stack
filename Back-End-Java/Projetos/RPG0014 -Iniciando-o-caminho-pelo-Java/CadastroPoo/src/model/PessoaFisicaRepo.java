package model;

import java.util.ArrayList;

public class PessoaFisicaRepo {
    private ArrayList<PessoaFisica> pessoaFisicas = new ArrayList<>();

    public void inserir(PessoaFisica pessoaFisica){
        pessoaFisicas.add(pessoaFisica);
    }

    public void alterar(int id, PessoaFisica pessoaFisica){
        for(int i = 0; i < pessoaFisicas.size(); i++){
            if(pessoaFisicas.get(i).getId() == id){
                pessoaFisicas.set(id, pessoaFisica);
                break;
            }
        }
    }

    public void excluir(int id){
        for(PessoaFisica pessoa : pessoaFisicas){
            if(pessoa.getId() == id){
                pessoaFisicas.remove(id);
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

    public static void main(String args[]){
        PessoaFisicaRepo p1 = new PessoaFisicaRepo();
        p1.inserir(new PessoaFisica("Thomazh",0,"123-456-789-01",19));
        p1.inserir(new PessoaFisica("Linconl",123,"123-456-789-01",18));
        p1.inserir(new PessoaFisica("Luiz",666,"123-456-789-01",20));

        System.out.println(p1.obterTodos());
    }
}
