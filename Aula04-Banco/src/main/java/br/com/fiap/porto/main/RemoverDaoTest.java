package br.com.fiap.porto.main;

import br.com.fiap.porto.dao.CarroDao;

import java.sql.SQLException;

public class RemoverDaoTest {

    public static void main(String[] args) {
        //Criar o objeto Dao
        CarroDao dao = new CarroDao();

        try {
            //Chamar o método remover
            dao.remover(2);
            System.out.println("Carro removido!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
