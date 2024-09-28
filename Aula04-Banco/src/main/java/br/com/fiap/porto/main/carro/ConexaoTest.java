package br.com.fiap.porto.main.carro;

import br.com.fiap.porto.factory.ConnectionFactory;
import java.sql.Connection;

public class ConexaoTest {

    public static void main(String[] args) {
        //Obter uma conexão com o banco de dados
        try {
            Connection conexao = ConnectionFactory.getConnection();
            System.out.println("Conexão com o banco obtido com sucesso!");
            conexao.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
