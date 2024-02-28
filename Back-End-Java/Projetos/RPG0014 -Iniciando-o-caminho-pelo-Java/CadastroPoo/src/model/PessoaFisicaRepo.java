package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

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
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(preFixo + "fisica"))) {
            out.writeObject(pessoaFisicas);
        } catch (IOException e) {
            // Lançar uma nova exceção com uma mensagem personalizada
            
            System.err.println("Erro ao persistir os dados: " + e.getMessage());
        }
    }

    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            Object obj = in.readObject();
            if (obj instanceof ArrayList<?>) {
                pessoaFisicas = (ArrayList<PessoaFisica>) Arrays.asList(((PessoaFisica[]) obj));          
            } else {
                throw new IOException("Arquivo não contém uma lista de pessoas físicas");
            }
        } catch(IOException e){
            throw e;
        } catch(ClassNotFoundException e){
            throw e;
        }
    }

    public static void main(String args[]){
        PessoaFisicaRepo p1 = new PessoaFisicaRepo();
        p1.inserir(new PessoaFisica("Thomazh",0,"123-456-789-01",19));
        p1.inserir(new PessoaFisica("Linconl",123,"123-456-789-01",18));
        p1.inserir(new PessoaFisica("Luiz",666,"123-456-789-01",20));

        System.out.println(p1.obterTodos());
    }
}
