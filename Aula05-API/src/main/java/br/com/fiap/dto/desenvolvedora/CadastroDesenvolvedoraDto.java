package br.com.fiap.dto.desenvolvedora;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CadastroDesenvolvedoraDto {

    @NotBlank
    @Size(max = 50)
    private String nome;

}
