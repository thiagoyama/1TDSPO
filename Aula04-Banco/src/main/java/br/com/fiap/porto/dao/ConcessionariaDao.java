package br.com.fiap.porto.dao;

import br.com.fiap.porto.exception.IdNaoEncontradoException;
import br.com.fiap.porto.model.Concessionaria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public Concessionaria pesquisarPorId(int id) throws SQLException, IdNaoEncontradoException {
        PreparedStatement stm = conexao.prepareStatement("select * from t_concessionaria where id_concessionaria = ?");
        stm.setInt(1, id);
        ResultSet resultSet = stm.executeQuery();
        if (!resultSet.next()){
            throw new IdNaoEncontradoException("Concessionaria não encontrada!");
        }
        return parseConcessionaria(resultSet);
    }

    private Concessionaria parseConcessionaria(ResultSet resultSet) throws SQLException {
        int codigo = resultSet.getInt("id_concessionaria");
        String nome = resultSet.getString("nm_concessionaria");
        String cnpj = resultSet.getString("nr_cnpj");
        int qtd = resultSet.getInt("nr_veiculos_maximo");
        return new Concessionaria(codigo, nome, cnpj, qtd);
    }

}
