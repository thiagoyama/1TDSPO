package br.com.fiap.teste;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EscritaArquivo {

    public static void main(String[] args) {
        try {
            //Abrir o arquivo em modo escrita
            FileWriter outputStream = new FileWriter("churros2.txt");
            PrintWriter writer = new PrintWriter(outputStream);

            Scanner sc = new Scanner(System.in);

            System.out.println("Digite o sabor do churros");
            String texto = sc.nextLine() + sc.next();
            //Escrever no arquivo
            writer.println(texto);

            //Fechar os recursos
            sc.close();
            outputStream.close();
            writer.close();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

}
