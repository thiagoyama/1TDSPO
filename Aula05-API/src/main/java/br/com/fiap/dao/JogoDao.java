package br.com.fiap.dao;

import br.com.fiap.exception.IdNaoEncontradoException;
import br.com.fiap.model.Classificacao;
import br.com.fiap.model.Jogo;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JogoDao {

    private static final String INSERT_SQL = "INSERT INTO T_JOGO (id_jogo, ds_nome, dt_lancamento, ds_classificacao) VALUES (SQ_T_JOGO.NEXTVAL, ?, ?, ?)";
    private static final String SELECT_BY_ID_SQL = "SELECT * FROM T_JOGO WHERE id_jogo = ?";
    private static final String SELECT_ALL_SQL = "SELECT * FROM T_JOGO";
    private static final String UPDATE_SQL = "UPDATE T_JOGO SET ds_nome = ?, dt_lancamento = ?, ds_classificacao = ? WHERE id_jogo = ?";
    private static final String DELETE_SQL = "DELETE FROM T_JOGO WHERE id_jogo = ?";

    private Connection conexao;

    public JogoDao(Connection conexao) {
        this.conexao = conexao;
    }

    public void cadastrar(Jogo jogo) throws SQLException {
        PreparedStatement stmt = conexao.prepareStatement(INSERT_SQL);
        preencherStatementComJogo(stmt, jogo);
        stmt.executeUpdate();
    }

    public Jogo pesquisarPorId(int id) throws IdNaoEncontradoException, SQLException {
        PreparedStatement stmt = conexao.prepareStatement(SELECT_BY_ID_SQL);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (!rs.next())
            throw new IdNaoEncontradoException("Jogo não encontrado");
        return parseJogo(rs);
    }

    public List<Jogo> listar() throws SQLException {
        Statement stmt = conexao.createStatement();
        ResultSet rs = stmt.executeQuery(SELECT_ALL_SQL);
        List<Jogo> jogos = new ArrayList<>();
        while (rs.next())
             jogos.add(parseJogo(rs));
        return jogos;
    }

    public void atualizar(Jogo jogo) throws IdNaoEncontradoException, SQLException {
        PreparedStatement stmt = conexao.prepareStatement(UPDATE_SQL);
        preencherStatementComJogo(stmt, jogo);
        stmt.setInt(4, jogo.getId());
        if (stmt.executeUpdate() == 0)
            throw new IdNaoEncontradoException("Jogo não encontrado");
    }

    public void remover(int id) throws IdNaoEncontradoException, SQLException {
        PreparedStatement stmt = conexao.prepareStatement(DELETE_SQL);
        stmt.setInt(1, id);
        if (stmt.executeUpdate() == 0)
            throw new IdNaoEncontradoException("Jogo não encontrado");
    }

    private void preencherStatementComJogo(PreparedStatement stmt, Jogo jogo) throws SQLException {
        stmt.setString(1, jogo.getNome());
        stmt.setDate(2, Date.valueOf(jogo.getDataLancamento()));
        if (jogo.getClassificacao() != null) {
            stmt.setString(3, jogo.getClassificacao().name());
        } else {
            stmt.setNull(3, Types.VARCHAR);
        }
    }

    private Jogo parseJogo(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id_jogo");
        String nome = resultSet.getString("ds_nome");
        LocalDate dataLancamento = resultSet.getDate("dt_lancamento").toLocalDate();
        String classificacaoStr = resultSet.getString("ds_classificacao");
        Classificacao classificacao = classificacaoStr != null ? Classificacao.valueOf(classificacaoStr) : null;

        return new Jogo(id, nome, dataLancamento, classificacao);
    }
}

