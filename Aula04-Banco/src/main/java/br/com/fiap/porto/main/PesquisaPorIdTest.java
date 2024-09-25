package br.com.fiap.porto.main;

import br.com.fiap.porto.dao.CarroDao;
import br.com.fiap.porto.exception.IdNaoEncontradoException;
import br.com.fiap.porto.model.Carro;

import java.sql.SQLException;

public class PesquisaPorIdTest {

    public static void main(String[] args) {
        //Instanciar um CarroDAO
        CarroDao carroDao = new CarroDao();

        try {
            //Pesquisar um carro pelo ID
            Carro carro =  carroDao.pesquisarPorId(9);
            //Exibir os dados do carro
            System.out.println(carro.getModelo() + " " + carro.getPlaca());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
