public class Alunos  extends Pessoa{
    // Atributos
    private String matricula;

    // Constructor
    public Alunos(String name, int age, String data_nascimento, String cpf, String matricula){
        // Usando super para buscar os atributos da classe acima
        super(name, age, data_nascimento, cpf);
    }
}
