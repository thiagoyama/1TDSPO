package br.com.fiap.dao;

import br.com.fiap.model.Desenvolvedora;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DesenvolvedoraDao {

    private static final String SQL_INSERT = "INSERT INTO t_desenvolvedora " +
            "(id_desenvolvedora, nm_desenvolvedora) values (sq_t_desenvolvedora.nextval, ?)";

    private Connection connection;

    public DesenvolvedoraDao(Connection connection){
        this.connection = connection;
    }

    public void cadastrar(Desenvolvedora desenvolvedora) throws SQLException {
        try (PreparedStatement stm = connection.prepareStatement(SQL_INSERT, new String[]{"id_desenvolvedora"})){
            stm.setString(1, desenvolvedora.getNome());
            stm.executeUpdate();
            ResultSet generatedKeys = stm.getGeneratedKeys();
            generatedKeys.next();
            desenvolvedora.setId(generatedKeys.getLong(1));
        }
    }

}
