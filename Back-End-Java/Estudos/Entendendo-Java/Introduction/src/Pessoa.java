public class Pessoa{
    // Atributos
    private String name;
    private int age;
    private String data_nascimento;
    private String cpf;

    // Constructor
    public Pessoa(String name, int age, String data_nascimento, String cpf){
        this.name = name;
        this.age = age;
        this.data_nascimento = data_nascimento;
        this.cpf = cpf;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return this.age;
    }

    public void setDataNascimento(String DataNascimento){
        this.data_nascimento = DataNascimento;
    }

    public String getDataNascimento(){
        return this.data_nascimento;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getCpf(){
        return this.cpf;
    }
}