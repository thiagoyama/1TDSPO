package br.com.fiap.porto.main.carro;

import br.com.fiap.porto.dao.CarroDao;
import br.com.fiap.porto.factory.ConnectionFactory;
import br.com.fiap.porto.model.Carro;
import java.util.List;

public class ListagemDaoTest {

    public static void main(String[] args) {

        try {
            //Instanciar o DAO
            CarroDao dao = new CarroDao(ConnectionFactory.getConnection());
            //Chamar o método listar
            List<Carro> lista = dao.listar();
            //Exibir os dados pesquisados
            for (Carro c : lista){
                System.out.println(c.getId() + " " + c.getModelo() + " " + c.getPlaca() + " " + c.getMotor() + " " + c.isAutomatico());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

    }
}
