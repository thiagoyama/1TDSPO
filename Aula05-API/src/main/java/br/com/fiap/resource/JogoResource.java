package br.com.fiap.resource;

import br.com.fiap.dao.JogoDao;
import br.com.fiap.dto.jogo.AtualizacaoJogoDto;
import br.com.fiap.dto.jogo.CadastroJogoDto;
import br.com.fiap.dto.jogo.DetalhesJogoDto;
import br.com.fiap.exception.IdNaoEncontradoException;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Jogo;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.modelmapper.ModelMapper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//http://localhost:8080/jogos
@Path("/jogos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JogoResource {

    private JogoDao jogoDao;
    private ModelMapper modelMapper;

    public JogoResource() throws Exception {
        jogoDao = new JogoDao(ConnectionFactory.getConnection());
        modelMapper = new ModelMapper();
    }

    @POST
    public Response cadastrar(@Valid CadastroJogoDto dto, @Context UriInfo uriInfo) throws SQLException {
        Jogo jogo = modelMapper.map(dto, Jogo.class);
        jogoDao.cadastrar(jogo);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(String.valueOf(jogo.getId())); //Constroi a URI para acessar o jogo cadastrado
        return Response.created(builder.build()).build();
    }

    @GET
    @Path("pesquisa") //http://localhost:8080/jogos/pesquisa?nome=xxx
    public List<DetalhesJogoDto> listaPorNome(@DefaultValue("") @QueryParam("nome") String nome) throws SQLException {
        return jogoDao.listarPorNome(nome).stream()
                .map(j -> modelMapper.map(j, DetalhesJogoDto.class))
                .collect(Collectors.toList());
    }

    @GET
    public List<DetalhesJogoDto> listar() throws SQLException {
        return jogoDao.listar().stream()
                .map(j -> modelMapper.map(j, DetalhesJogoDto.class))
                .collect(Collectors.toList());
    }

    @GET
    @Path("/{id}")
    public DetalhesJogoDto pesquisar(@PathParam("id") int id) throws SQLException, IdNaoEncontradoException {
        Jogo jogo = jogoDao.pesquisarPorId(id);
        DetalhesJogoDto dto = modelMapper.map(jogo, DetalhesJogoDto.class);
        return dto;
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") int id, @Valid AtualizacaoJogoDto dto) throws IdNaoEncontradoException, SQLException {
        Jogo jogo = modelMapper.map(dto, Jogo.class);
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
    public Response atualizarParcial(@PathParam("id") int id, @Valid AtualizacaoJogoDto dto) throws IdNaoEncontradoException, SQLException {
        //Pesquisar o jogo no banco de dados
        Jogo jogoBanco = jogoDao.pesquisarPorId(id);
        //Verifica se existe valor no objeto recebido, eu seto o novo valor no objeto do banco
        if (dto.getNome() != null)
            jogoBanco.setNome(dto.getNome());
        if (dto.getClassificacao() != null)
            jogoBanco.setClassificacao(dto.getClassificacao());
        if (dto.getDataLancamento() != null)
            jogoBanco.setDataLancamento(dto.getDataLancamento());
        jogoDao.atualizar(jogoBanco);
        return Response.ok().build();
    }

}
