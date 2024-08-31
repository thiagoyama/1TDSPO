package br.com.fiap.teste;

import java.io.*;

public class Exercicio2 {

    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("soma.txt");
            BufferedReader inputStream = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter("exercicioSaida.txt", true);
            PrintWriter outputStream = new PrintWriter(fileWriter);

            String linha;
            while ((linha = inputStream.readLine())!= null){
                //Separa os valores pelo caractere ","
                //String[] valores = linha.split(",");
                int n1 = Integer.parseInt(linha.substring(0, linha.indexOf(",")));
                int n2 = Integer.parseInt(linha.substring(linha.indexOf(",")+1));
                int soma = n1 + n2;
                outputStream.println(linha + "," + soma);
            }

            fileReader.close();
            outputStream.close();
            fileReader.close();
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
