package br.com.fiap.porto.dao;

import br.com.fiap.porto.factory.ConnectionFactory;
import br.com.fiap.porto.model.Carro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

//Classe responsável por interagir com o banco de dados e realizar ações ações na tabela T_CARRO
public class CarroDao {

    public void cadastrar(Carro carro) throws SQLException, ClassNotFoundException {
        Connection conexao = ConnectionFactory.getConnection();
        //Criar um statement configurável
        PreparedStatement stmt = conexao.prepareStatement ("insert into t_carro (id_carro, ds_modelo, " +
                "nr_placa, ds_motor, ds_automatico) values (sq_t_carro.nextval, ?, ?, ?, ?)");
        //Setar os valores do carro na query
        stmt.setString(1, carro.getModelo());
        stmt.setString(2, carro.getPlaca());
        stmt.setFloat(3, carro.getMotor());
        stmt.setBoolean(4, carro.isAutomatico());
        //Executar o comando SQL
        stmt.executeUpdate();
    }

    //TAREFA
    public List<Carro> listar(){
        return null;
    }

    //DESAFIO
    public void atualizar(Carro carro){

    }

    public void remover(int id){

    }

}
