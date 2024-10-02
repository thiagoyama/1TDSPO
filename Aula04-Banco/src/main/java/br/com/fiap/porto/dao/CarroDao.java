package br.com.fiap.porto.dao;

import br.com.fiap.porto.exception.IdNaoEncontradoException;
import br.com.fiap.porto.factory.ConnectionFactory;
import br.com.fiap.porto.model.Carro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//Classe responsável por interagir com o banco de dados e realizar ações ações na tabela T_CARRO
public class CarroDao {

    private  Connection conexao;

    public CarroDao(Connection conexao){
        this.conexao = conexao;
    }

    public void cadastrar(Carro carro) throws SQLException, ClassNotFoundException {
        //Criar um statement configurável
        PreparedStatement stmt = conexao.prepareStatement ("insert into t_carro (id_carro, ds_modelo, " +
                "nr_placa, ds_motor, ds_automatico, fk_id_concessionaria) " +
                "values (sq_t_carro.nextval, ?, ?, ?, ?, ?)");
        //Setar os valores do carro na query
        stmt.setString(1, carro.getModelo());
        stmt.setString(2, carro.getPlaca());
        stmt.setFloat(3, carro.getMotor());
        stmt.setBoolean(4, carro.isAutomatico());
        if (carro.getConcessionaria() != null)
            stmt.setInt(5, carro.getConcessionaria().getId());
        else
            stmt.setNull(5, Types.INTEGER);
        //Executar o comando SQL
        stmt.executeUpdate();
    }

    public Carro pesquisarPorId(int id) throws IdNaoEncontradoException, SQLException, ClassNotFoundException {
        //Criar o PreparementStatement
        PreparedStatement stm = conexao.prepareStatement("select * from t_carro where id_carro = ?");
        //Setar o id no comando SQL
        stm.setInt(1, id);
        //Executar o comando SQL
        ResultSet resultSet = stm.executeQuery();
        //Recuperar o registro, se existir
        if (!resultSet.next()){
             throw new IdNaoEncontradoException("Carro não encontrado");
        }
        return parseCarro(resultSet);
    }

    public List<Carro> listar() throws SQLException, ClassNotFoundException {
        //Criar o Statement
        Statement stm = conexao.createStatement();
        //Executar o comando SQL
        ResultSet resultSet = stm.executeQuery("select * from t_carro");
        //Criar a lista de carro
        List<Carro> lista = new ArrayList<>();
        //Percorrer os registros encontrados
        while (resultSet.next()){
            Carro carro = parseCarro(resultSet);
            //Adiciona o carro na lista
            lista.add(carro);
        }
        //Retornar a lista de carro
        return lista;
    }

    private Carro parseCarro(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id_carro");
        String modelo = resultSet.getString("ds_modelo");
        String placa = resultSet.getString("nr_placa");
        float motor = resultSet.getFloat("ds_motor");
        boolean automatico = resultSet.getBoolean("ds_automatico");
        //Criar o objeto carro
        Carro carro = new Carro(id, modelo, placa, motor, automatico);
        return carro;
    }

    //DESAFIO
    public void atualizar(Carro carro) throws IdNaoEncontradoException, SQLException, ClassNotFoundException {
        //Criar o PreparedStatement
        PreparedStatement stm = conexao.prepareStatement("update t_carro set ds_modelo = ?, " +
                "nr_placa = ?, ds_motor = ?, ds_automatico =? where id_carro = ?");
        //Setar os valores no SQL
        stm.setString(1, carro.getModelo());
        stm.setString(2, carro.getPlaca());
        stm.setFloat(3, carro.getMotor());
        stm.setBoolean(4, carro.isAutomatico());
        stm.setInt(5, carro.getId());
        //Executar o comando
        int linhas = stm.executeUpdate();
        if (linhas == 0)
            throw new IdNaoEncontradoException("Carro não encontrado");
    }

    public void remover(int id) throws IdNaoEncontradoException, SQLException, ClassNotFoundException {
        //Criar o PreparedStatement
        PreparedStatement stm = conexao.prepareStatement("delete from t_carro where id_carro = ?");
        //Setar o valor no SQL
        stm.setInt(1, id);
        //Executar o comando e recuperar a quantidade de linhas removidas
        int linhas = stm.executeUpdate();
        if (linhas == 0)
            throw new IdNaoEncontradoException("Carro não encontrado");
    }

}
