package br.com.fiap.porto.main.carro;

import br.com.fiap.porto.dao.CarroDao;
import br.com.fiap.porto.dao.ConcessionariaDao;
import br.com.fiap.porto.factory.ConnectionFactory;
import br.com.fiap.porto.model.Carro;
import br.com.fiap.porto.model.Concessionaria;

import javax.swing.*;
import java.sql.SQLException;

public class CadastroDaoTest {

    public static void main(String[] args) {
        //Ler os dados do carro
        String modelo = JOptionPane.showInputDialog("Digite o modelo do carro");
        String placa = JOptionPane.showInputDialog("Digite a placa do carro");
        float motor = Float.parseFloat(JOptionPane.showInputDialog("Digite o motor do carro"));
        boolean automatico = JOptionPane.showConfirmDialog(null, "É automático?",
                        "Automático", JOptionPane.YES_NO_OPTION) == 0;

        boolean vaiConcessionaria = JOptionPane.showConfirmDialog(null,
                "Deseja adicionar a concessionaria",
                "Confirmação", JOptionPane.YES_NO_OPTION) == 0;

        //Instanciar o carro
        Carro carro = new Carro(modelo, placa, motor, automatico);
        try {

            if (vaiConcessionaria){
                int idCon = Integer.parseInt(JOptionPane.showInputDialog("Digite o código da concessionaria"));
                ConcessionariaDao concessionariaDao = new ConcessionariaDao(ConnectionFactory.getConnection());
                Concessionaria concessionaria = concessionariaDao.pesquisarPorId(idCon);
                carro.setConcessionaria(concessionaria);
            }

            //Instanciar o Dao
            CarroDao carroDao = new CarroDao(ConnectionFactory.getConnection());
            //Chamar o método para cadastrar
            carroDao.cadastrar(carro);
            System.out.println("Cadastro realizado!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
