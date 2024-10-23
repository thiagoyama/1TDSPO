package br.com.fiap.dto.erro;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ValidacaoErroDto {

    private String mensagem;

    private List<CampoErroDto> campos;

}
