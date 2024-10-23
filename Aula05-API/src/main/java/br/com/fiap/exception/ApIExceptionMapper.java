package br.com.fiap.exception;

import br.com.fiap.dto.erro.MensagemErroDto;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

//Mapear as exceptions do Java para Status Code do HTTP
@Provider
public class ApIExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception e) {
        //Validar o tipo de exception que será tratada
        if (e instanceof IdNaoEncontradoException){
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new MensagemErroDto(e.getMessage()))
                    .build();
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new MensagemErroDto(e.getMessage()))
                    .build();
    }
}
