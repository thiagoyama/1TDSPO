package br.com.fiap.main;

import br.com.fiap.model.Aluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio02 {

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        List<Aluno> alunos = new ArrayList<>();
        String resposta;
        do {
            //Ler as informações do aluno
            System.out.println("Digite o nome");
            String nome = leitor.next() + leitor.nextLine();
            System.out.println("Digite a idade");
            int idade = leitor.nextInt();
            System.out.println("Digite o RM");
            String rm = leitor.next() + leitor.nextLine();
            System.out.println("Digite a nota 1");
            double nota1 = leitor.nextDouble();
            System.out.println("Digite a nota 2");
            double nota2 = leitor.nextDouble();
            Aluno aluno = new Aluno(nome, rm, idade, nota1, nota2);
            alunos.add(aluno); //adiciona o aluno na lista
            //Perguntar se deseja adicionar mais alunos
            System.out.println("Deseja cadastrar mais um aluno? (s/n)");
            resposta = leitor.next();
        } while(!resposta.equalsIgnoreCase("n"));
        leitor.close();
        double somaMediaGeral = 0;
        int somaIdadeGeral = 0;
        int menorIdade = alunos.get(0).getIdade();
        int maiorIdade = alunos.get(0).getIdade();
        //Imprimir os alunos
        for (Aluno aluno : alunos){
            System.out.println(aluno);
            somaMediaGeral += aluno.calcularMedia();
            somaIdadeGeral += aluno.getIdade();
            if (aluno.getIdade() > maiorIdade)
                maiorIdade = aluno.getIdade();
            if (aluno.getIdade() < menorIdade)
                menorIdade = aluno.getIdade();
        }
        System.out.println("Quantidade de alunos: " + alunos.size());
        System.out.println("Média de notas: " + somaMediaGeral/alunos.size());
        System.out.println("Média de idade: " + somaIdadeGeral/alunos.size());
        System.out.println("Maior idade: " + maiorIdade);
        System.out.println("Menor idade: " + menorIdade);

    }

}
