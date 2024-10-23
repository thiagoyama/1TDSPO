package br.com.fiap.exception;

import br.com.fiap.dto.erro.CampoErroDto;
import br.com.fiap.dto.erro.ValidacaoErroDto;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.ArrayList;
import java.util.List;

@Provider
public class ApiValidationMapper
            implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException e) {
        List<CampoErroDto> erroCampos = new ArrayList<>();
        //Percorrer cada erro encontrado nos campos
        for (ConstraintViolation<?> c : e.getConstraintViolations()){
            CampoErroDto campoErroDto = new CampoErroDto();
            campoErroDto.setCampo(c.getPropertyPath().toString());
            campoErroDto.setMensagem(c.getMessage());
            erroCampos.add(campoErroDto);
        }
        //Retornar o Bad Request com os erros
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ValidacaoErroDto("Dados inválidos", erroCampos))
                .build();
    }
}
