package br.com.fiap.resource;

import br.com.fiap.dao.DesenvolvedoraDao;
import br.com.fiap.dao.JogoDao;
import br.com.fiap.dto.desenvolvedora.CadastroDesenvolvedoraDto;
import br.com.fiap.dto.desenvolvedora.DetalhesDesenvolvedoraDto;
import br.com.fiap.dto.jogo.DetalhesJogoDto;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Desenvolvedora;
import br.com.fiap.model.Jogo;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.modelmapper.ModelMapper;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Path("/desenvolvedoras")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DesenvolvedoraResource {

    private DesenvolvedoraDao desenvolvedoraDao;

    private JogoDao jogoDao;

    private ModelMapper modelMapper;

    public DesenvolvedoraResource() throws SQLException, ClassNotFoundException {
        desenvolvedoraDao = new DesenvolvedoraDao(ConnectionFactory.getConnection());
        jogoDao = new JogoDao(ConnectionFactory.getConnection());
        modelMapper = new ModelMapper();
    }

    @GET
    @Path("/{id}/jogos")
    public List<DetalhesJogoDto> pesquisarJogoPorDesenvolvedora(@PathParam("id") int id)
                                                                    throws SQLException {
        return jogoDao.listarPorIdDesenvolvedora(id)
                .stream().map(j -> modelMapper.map(j, DetalhesJogoDto.class))
                .collect(Collectors.toList());
    }



    @POST
    public Response cadastrar(CadastroDesenvolvedoraDto dto, @Context UriInfo uriInfo) throws SQLException {
        Desenvolvedora desenvolvedora = modelMapper.map(dto, Desenvolvedora.class);
        desenvolvedoraDao.cadastrar(desenvolvedora);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(String.valueOf(desenvolvedora.getId()));
        return Response.created(builder.build()).entity(modelMapper.map(desenvolvedora, DetalhesDesenvolvedoraDto.class)).build();
    }

}
