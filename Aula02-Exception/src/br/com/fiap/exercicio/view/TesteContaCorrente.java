package br.com.fiap.exercicio.view;

import br.com.fiap.exercicio.exception.TaLisoException;
import br.com.fiap.exercicio.model.ContaCorrente;

import java.util.Scanner;

public class TesteContaCorrente {

    public static void main(String[] args) {
        //Instanciar uma Conta Corrente
        ContaCorrente cc = new ContaCorrente(100, 100);
        Scanner sc = new Scanner(System.in);

        try {
            //Pedir o valor para sacar
            System.out.println("Digite o valor para sacar");
            double valor = sc.nextDouble();
            cc.sacar(valor);
            System.out.println("Saldo atual: " + cc.getSaldo());
        } catch (TaLisoException e){
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro");
            System.err.println(e.getMessage());
            sc.nextLine();
        }

        try {
            //Pedir o valor para depositar
            System.out.println("Digite o valor para deposito");
            double valor = sc.nextDouble();
            cc.depositar(valor);
            System.out.println("Saldo atual: " + cc.getSaldo());
        } catch (Exception e){
            System.err.println(e.getMessage());
            sc.nextLine();
        }

        try {
            //Pedir o valor para alterar o limite
            System.out.println("Digite o novo valor para o limite");
            double valor = sc.nextDouble();
            cc.setLimite(valor);
            System.out.println("Novo limite: " + cc.getLimite());
        } catch (Exception e){
            System.err.println(e.getMessage());
        }

    }
}
