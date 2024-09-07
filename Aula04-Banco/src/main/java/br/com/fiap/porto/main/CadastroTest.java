package br.com.fiap.porto.main;

import br.com.fiap.porto.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.Statement;

public class CadastroTest {

    public static void main(String[] args) {
        //Executar o comando de insert, para cadastrar um carro
        try{
            //Obter uma conexão com o banco
            Connection conexao = ConnectionFactory.getConnection();
            System.out.println("Conexão realizada com sucesso!");
            //Criar um statement
            Statement stmt = conexao.createStatement();
            //Executar o comando insert, para cadastrar um carro
            stmt.executeUpdate("insert into t_carro (id_carro, ds_modelo, nr_placa, ds_motor, ds_automatico) values (sq_t_carro.nextval, 'Fusca', 'ABC1234', 1, 0)");
            System.out.println("Linha criada com sucesso!");
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

}
