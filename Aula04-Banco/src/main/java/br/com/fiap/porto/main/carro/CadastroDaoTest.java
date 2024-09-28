package br.com.fiap.porto.main.carro;

import br.com.fiap.porto.dao.CarroDao;
import br.com.fiap.porto.model.Carro;

import javax.swing.*;
import java.sql.SQLException;

public class CadastroDaoTest {

    public static void main(String[] args) {
        //Ler os dados do carro
        String modelo = JOptionPane.showInputDialog("Digite o modelo do carro");
        String placa = JOptionPane.showInputDialog("Digite a marca do carro");
        float motor = Float.parseFloat(JOptionPane.showInputDialog("Digite o motor do carro"));
        boolean automatico = JOptionPane.showConfirmDialog(null, "É automático?",
                        "Automático", JOptionPane.YES_NO_OPTION) == 0;
        //Instanciar o carro
        Carro carro = new Carro(modelo, placa, motor, automatico);
        //Instanciar o Dao
        CarroDao carroDao = new CarroDao();
        //Chamar o método para cadastrar
        try {
            carroDao.cadastrar(carro);
            System.out.println("Cadastro realizado!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
