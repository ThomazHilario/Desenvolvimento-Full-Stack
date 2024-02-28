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

                case 2:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String tipoPessoa = sc.nextLine();

                    if(tipoPessoa.equalsIgnoreCase("f") == true){
                        System.out.println("O id do usuario que vc quer editar:");
                        int idUser = sc.nextInt();
                        sc.nextLine();

                        // Mostrando dados atuais
                        System.out.println("Dados atuais:");
                        System.out.println(repoFisica.obter(idUser).getName());
                        System.out.println(repoFisica.obter(idUser).getIdade());
                        System.out.println(repoFisica.obter(idUser).getCpf());
                        
                        // Insira os novos dados
                        System.out.println("Nome do usuario:");
                        String nomeUser = sc.nextLine();

                        System.out.println("Cpf do usuario:");
                        String cpfUser = sc.nextLine();

                        System.out.println("Idade do usuario:");
                        int idadeUser = sc.nextInt();
                        sc.nextLine();

                        repoFisica.alterar(idUser, new PessoaFisica(nomeUser, idUser, cpfUser, idadeUser));
                    }

                break;

                case 3:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String excluirPessoa = sc.nextLine();

                    if(excluirPessoa.equalsIgnoreCase("f") == true){
                        System.out.println("Digite o id da pessoa que deseja excluir: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        // Excluindo pessoa Fisica
                        repoFisica.excluir(id);

                    } else if(excluirPessoa.equalsIgnoreCase("j") == true){
                        System.out.println("Digite o id da pessoa que deseja excluir: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        // Excluindo pessoa juridica
                        repoJuridica.excluir(id);
                    } else{
                        System.out.println("Ocorreu algum erro!");
                    }
                break;

                case 4:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String obterPessoa = sc.nextLine();

                    if(obterPessoa.equalsIgnoreCase("f") == true){
                        System.out.println("Digite o id da pessoa que deseja obter: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        // Exibindo dados
                        System.out.println("Nome: " + repoFisica.obter(id).getName());
                        System.out.println("Idade: " + repoFisica.obter(id).getIdade());
                        System.out.println("Cpf: " + repoFisica.obter(id).getCpf());

                    } else if(obterPessoa.equalsIgnoreCase("j") == true){
                        System.out.println("Digite o id da pessoa que deseja obter: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        // Exibindo dados
                        System.out.println("Nome: " + repoJuridica.obter(id).getName());
                        System.out.println("Cnpj: " + repoJuridica.obter(id).getCnpf());

                    } else{
                        System.out.println("Ocorreu algum erro!");
                    }
                break;

                case 5:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String obterTodos = sc.nextLine();

                    if(obterTodos.equalsIgnoreCase("f")){
                        for(PessoaFisica pessoa : repoFisica.obterTodos()){
                            System.out.println("Id: " + pessoa.getId());
                            System.out.println("Nome: " + pessoa.getName());
                            System.out.println("Idade: " + pessoa.getIdade());
                            System.out.println("Cpf: " + pessoa.getCpf());
                            System.out.println("------------------------");
                        };
                    } else if(obterTodos.equalsIgnoreCase("j")){
                        for(PessoaJuridica pessoa : repoJuridica.obterTodos()){
                            System.out.println("Id: " + pessoa.getId());
                            System.out.println("Nome: " + pessoa.getName());
                            System.out.println("Cnpj: " + pessoa.getCnpf());
                            System.out.println("------------------------");
                        };
                    }
                break;
            }

        } while (opcao != 0);

        sc.close();
    }
}
