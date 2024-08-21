package br.com.fiap.view;

import br.com.fiap.exception.MesesInvalidoException;
import br.com.fiap.model.Funcionario;

import java.util.Scanner;

public class FuncionarioView {

    public static void main(String[] args) {
        //Instanciar um Funcionario com os valores
        Funcionario jorge = new Funcionario("Jorge", 5000);
        //Pedir para o usuário a qtd de meses trabalhada
        Scanner sc = new Scanner(System.in);
        try {

            System.out.println("Digite a quantidade de meses trabalhada");
            int meses = sc.nextInt();

            //Calcular o PLR do funcionário
            double plr = jorge.calcularPlr(true, meses);
            System.out.printf("PLR: " + plr);

            System.out.println("Digite a quantidade de dias de férias");
            int dias = sc.nextInt();

            double ferias = jorge.calcularFerias(dias);
            System.out.println("Férias: " + ferias);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        try {

            System.out.println("Digite a quantidade de meses trabalhada");
            int meses = sc.nextInt();

            //Calcular o PLR do funcionário
            double plr = jorge.calcularPlr(true, meses);
            System.out.printf("PLR: " + plr);

            System.out.println("Digite a quantidade de dias de férias");
            int dias = sc.nextInt();

            double ferias = jorge.calcularFerias(dias);
            System.out.println("Férias: " + ferias);

        }catch (MesesInvalidoException e){
            System.out.println("Tratamento diferenciado...");
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

}
