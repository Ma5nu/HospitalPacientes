package gestaoPaciente2.Dominio;

/**
 * Classe Paciente
 * @author adm
 */
public class Paciente {
    private int id;
    private String nome;
    private double peso;
    private double altura;
    private char sexo;

    // Construtor
    public Paciente(int id, String nome, double peso, double altura, char sexo) {
        this.id = id;
        this.nome = nome;
        this.peso = peso;
        this.altura = altura;
        this.sexo = sexo;
    }

    // Métodos de acesso e modificação
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                ", sexo=" + (sexo == 'M' || sexo == 'F' ? "Masculino" : "Feminino") +
                '}';
    }
}