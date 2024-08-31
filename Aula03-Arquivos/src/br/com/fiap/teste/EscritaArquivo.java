package br.com.fiap.teste;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EscritaArquivo {

    public static void main(String[] args) {

        try {
            //Abrir o arquivo em modo escrita
            FileWriter outputStream = new FileWriter("churros2.txt", true);
            PrintWriter writer = new PrintWriter(outputStream);

            System.out.println("Digite o sabor do churros");
            String texto = JOptionPane.showInputDialog("Digite o sabor");
            //Escrever no arquivo
            writer.println(texto);

            //Fechar os recursos
            outputStream.close();
            writer.close();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

}
