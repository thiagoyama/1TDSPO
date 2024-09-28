package br.com.fiap.porto.dao;

import br.com.fiap.porto.model.Concessionaria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConcessionariaDao {

    private Connection conexao;

    public ConcessionariaDao(Connection connection){
        this.conexao = connection;
    }

    public void cadastrar(Concessionaria concessionaria) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("insert into t_concessionaria (id_concessionaria, " +
                "nm_concessionaria, nr_cnpj, nr_veiculos_maximo) values " +
                "(sq_t_concessionaria.nextval, ?, ?, ?)");
        stm.setString(1, concessionaria.getNome());
        stm.setString(2, concessionaria.getCnpj());
        stm.setInt(3, concessionaria.getMaximoVeiculos());
        stm.executeUpdate();
    }

}
