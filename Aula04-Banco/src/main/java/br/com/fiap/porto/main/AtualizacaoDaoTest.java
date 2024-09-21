package br.com.fiap.porto.main;

import br.com.fiap.porto.dao.CarroDao;
import br.com.fiap.porto.model.Carro;

import java.sql.SQLException;

public class AtualizacaoDaoTest {

    public static void main(String[] args) {

        //Criar o objeto carro (Com ID)
        Carro carro = new Carro(2, "Gol Bola", "ABC1234", 1, false);

        //Criar o objeto DAO
        CarroDao dao = new CarroDao();

        try {
            //Chamar o método para atualizar
            dao.atualizar(carro);
            System.out.println("Carro atualizado!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
