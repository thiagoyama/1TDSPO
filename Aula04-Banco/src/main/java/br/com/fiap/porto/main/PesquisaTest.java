package br.com.fiap.porto.main;

import br.com.fiap.porto.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PesquisaTest {

    public static void main(String[] args) {
        try {
            //Obter a conexão com o banco
            Connection conexao = ConnectionFactory.getConnection();
            //Criar o Statement
            Statement statement = conexao.createStatement();
            //Executar a pesquisa no banco de dados
            ResultSet resultSet = statement.executeQuery("select * from t_carro order by id_carro");
            //Percorrer todos os registros encontrados
            while (resultSet.next()) {
                //Recuperar os valores das colunas do registro
                int codigo = resultSet.getInt("id_carro");
                String modelo = resultSet.getString("ds_modelo");
                double motor = resultSet.getDouble("ds_motor");
                String placa = resultSet.getString("nr_placa");
                boolean automatico = resultSet.getBoolean("ds_automatico");
                System.out.println(codigo + " " + modelo + " " + motor + " " + placa + " " + automatico);
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
