public class Principal {
    private static Alunos aluno;

    public static void main(String args[]){
        aluno = new Alunos("Thomaz", 18, null, null, null);

        aluno.setDataNascimento("15/03/2005");
        aluno.setCpf("123-456-789-10");

        aluno.informationUser();
    }
}
