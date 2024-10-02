package br.com.fiap.porto.main.carro;

import br.com.fiap.porto.dao.CarroDao;
import br.com.fiap.porto.factory.ConnectionFactory;

import java.sql.SQLException;

public class RemoverDaoTest {

    public static void main(String[] args) {


        try {
            //Criar o objeto Dao
            CarroDao dao = new CarroDao(ConnectionFactory.getConnection());
            //Chamar o método remover
            dao.remover(3);
            System.out.println("Carro removido!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
