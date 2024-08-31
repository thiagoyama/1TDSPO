package br.com.fiap.teste;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeituraArquivo {

    public static void main(String[] args) {
        try {
            //Ler o arquivo "churros2.txt"
            FileReader fileReader = new FileReader("churros2.txt");
            BufferedReader inputStream = new BufferedReader(fileReader);
            //Exibir os sabores do churros
            String linha;
            while ((linha = inputStream.readLine()) != null){
                System.out.println(linha);
            }
            fileReader.close();
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
