package br.com.fiap.resource;

import br.com.fiap.dao.DesenvolvedoraDao;
import br.com.fiap.dto.desenvolvedora.CadastroDesenvolvedoraDto;
import br.com.fiap.dto.desenvolvedora.DetalhesDesenvolvedoraDto;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Desenvolvedora;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.*;
import org.modelmapper.ModelMapper;

import java.sql.SQLException;

@Path("/desenvolvedoras")
@Consumes(MediaType.APPLICATION_JSON)
public class DesenvolvedoraResource {

    private DesenvolvedoraDao desenvolvedoraDao;

    private ModelMapper modelMapper;

    public DesenvolvedoraResource() throws SQLException, ClassNotFoundException {
        desenvolvedoraDao = new DesenvolvedoraDao(ConnectionFactory.getConnection());
        modelMapper = new ModelMapper();
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
