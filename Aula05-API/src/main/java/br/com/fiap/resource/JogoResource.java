package br.com.fiap.resource;

import br.com.fiap.dao.JogoDao;
import br.com.fiap.exception.IdNaoEncontradoException;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Jogo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.sql.SQLException;
import java.util.List;

//http://localhost:8080/jogos
@Path("/jogos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JogoResource {

    private JogoDao jogoDao;

    public JogoResource() throws Exception {
        jogoDao = new JogoDao(ConnectionFactory.getConnection());
    }

    @POST
    public Response cadastrar(Jogo jogo, @Context UriInfo uriInfo) throws SQLException {
        jogoDao.cadastrar(jogo);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(String.valueOf(jogo.getId())); //Constroi a URI para acessar o jogo cadastrado
        return Response.created(builder.build()).build();
    }

    @GET
    public List<Jogo> listar() throws SQLException {
        return jogoDao.listar();
    }

    @GET
    @Path("/{id}")
    public Jogo pesquisar(@PathParam("id") int id) throws IdNaoEncontradoException, SQLException {
        return jogoDao.pesquisarPorId(id);
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") int id, Jogo jogo) throws IdNaoEncontradoException, SQLException {
        //Setar o id no jogo
        jogo.setId(id);
        //Atualizar o jogo
        jogoDao.atualizar(jogo);
        //Retornar o status 200 OK
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response remover(@PathParam("id") int id) throws IdNaoEncontradoException, SQLException {
        jogoDao.remover(id);
        return Response.noContent().build();
    }

    @PATCH //Realizar a atualização parcial do objeto
    @Path("/{id}")
    public Response atualizarParcial(@PathParam("id") int id, Jogo jogo) throws IdNaoEncontradoException, SQLException {
        //Pesquisar o jogo no banco de dados
        Jogo jogoBanco = jogoDao.pesquisarPorId(id);
        //Verifica se existe valor no objeto recebido, eu seto o novo valor no objeto do banco
        if (jogo.getNome() != null)
            jogoBanco.setNome(jogo.getNome());
        if (jogo.getClassificacao() != null)
            jogoBanco.setClassificacao(jogo.getClassificacao());
        if (jogo.getDataLancamento() != null)
            jogoBanco.setDataLancamento(jogo.getDataLancamento());
        jogoDao.atualizar(jogoBanco);
        return Response.ok().build();
    }

}
