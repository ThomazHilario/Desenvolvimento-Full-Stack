package model;

import java.util.Scanner;

public class CadastroPoo {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();

        

        int opcao;
        

        do {

            System.out.println("Escolha uma opcao: ");
            System.out.println("1 - Incluir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Obter");
            System.out.println("5 - ObterTodos");
            System.out.println("6 - Persistir");
            System.out.println("7 - Recuperar");

            opcao = sc.nextInt();
            sc.nextLine();


            switch(opcao){
                case 1:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String pessoaTipo = sc.nextLine();

                    if(pessoaTipo.equalsIgnoreCase("f") == true){

                        // Scanner de campos
                        System.out.println("Id do usuario: ");
                        int id = sc.nextInt();
                        sc.nextLine();


                        System.out.println("Nome do usuario");
                        String nome = sc.nextLine();

                        System.out.println("Idade do usuario");
                        int idade = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Cpf do usuario");
                        String cpf = sc.nextLine();
                        

                        // Instanciando / criando - pessoa fisica
                        repoFisica.inserir(new PessoaFisica(nome, id, cpf, idade));

                    }else if(pessoaTipo.equalsIgnoreCase("j") == true){
                        // scanner campos
                        System.out.println("Id do usuario: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Nome do usuario");
                        String nome = sc.nextLine();

                        System.out.println("Cnpj do usuario: ");
                        String cnpj = sc.nextLine();

                        // Instanciando / criando - pessoa Juridica
                        repoJuridica.incluir(new PessoaJuridica(nome, id, cnpj));
                    }
                break;

                case 4:
                    System.out.println("F - Pessooa Fisica | J - Pessoa Juridica");

                break;
            }

        } while (opcao != 0);

        sc.close();
    }
}
