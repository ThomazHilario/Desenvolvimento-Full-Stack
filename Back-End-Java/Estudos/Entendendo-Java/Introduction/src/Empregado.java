public class Empregado extends Pessoa{
    protected double matricula;

    public Empregado(String name, int age, String data_nascimento, String cpf){
        super(name, age, data_nascimento, cpf);
        this.matricula = gerarMatricula();
    }

    protected double gerarMatricula(){
        double randomNumber = Math.random();
        
        return this.matricula = randomNumber;
    }
}
