package br.com.fiap.model;

public class Aluno {

    private String nome;
    private String rm;
    private int idade;
    private double nota1;
    private double nota2;

    public Aluno(String nome, String rm, int idade, double nota1, double nota2) {
        this.nome = nome;
        this.rm = rm;
        this.idade = idade;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    //Método para calcular a média do aluno
    public double calcularMedia(){
        return (nota1 + nota2) / 2;
    }

    @Override
    public String toString() {
        return  "nome: " + nome +
                ", rm: " + rm +
                ", idade: " + idade +
                ", nota1: " + nota1 +
                ", nota2: " + nota2;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRm() {
        return rm;
    }

    public void setRm(String rm) {
        this.rm = rm;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }
}
