package br.com.fiap.teste;

import java.io.File;
import java.io.IOException;

public class ArquivoTeste {

    public static void main(String[] args) {
        //Criar um objeto que representa uma pasta
        File pasta = new File("churros");

        //Se a pasta não existir, criar a pasta
        if (!pasta.exists()){
            pasta.mkdir(); //criar a pasta
            System.out.println("Pasta criada!");
        }

        //Criar um arquivo dentro da pasta churros
        File arquivo = new File(pasta, "doce.txt");
        if (!arquivo.exists()){
            try {
                arquivo.createNewFile();
                System.out.println("Arquivo criado!");
            } catch (IOException e) {
                System.err.println("Não foi possível criar o arquivo");
            }
        }
    }
}
