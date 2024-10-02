package br.com.fiap.porto.main.carro;

import br.com.fiap.porto.dao.CarroDao;
import br.com.fiap.porto.exception.IdNaoEncontradoException;
import br.com.fiap.porto.factory.ConnectionFactory;
import br.com.fiap.porto.model.Carro;

import java.sql.SQLException;

public class PesquisaPorIdTest {

    public static void main(String[] args) {

        try {
            //Instanciar um CarroDAO
            CarroDao carroDao = new CarroDao(ConnectionFactory.getConnection());

            //Pesquisar um carro pelo ID
            Carro carro =  carroDao.pesquisarPorId(9);
            //Exibir os dados do carro
            System.out.println(carro.getModelo() + " " + carro.getPlaca());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
