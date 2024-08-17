import javax.swing.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try {
            //Ler um número
            int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um número"));
            System.out.println(numero);
            //Ler outro número
            int numero2 = Integer.parseInt(JOptionPane.showInputDialog("Digite outro número"));
            System.out.println(numero2);
            //Dividir um número por outro
            int divisao = numero/numero2;
            System.out.println("Divisão: " + divisao);
        } catch (NumberFormatException e){
            System.out.println(e.getMessage());
        } catch (ArithmeticException e){
            System.out.println("Não é possível realizar uma divisão por zero");
        } catch (Exception e){
            System.out.println("Tratando todos os erros");
        } finally {
            System.out.println("Finalizando o programa");
        }

    }
}