package br.com.fiap.dto.jogo;

import br.com.fiap.model.Classificacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

//Define os dados utilizados para o cadastro
@Setter @Getter
public class CadastroJogoDto {

    @NotBlank //Não pode ser nulo ou vazio
    @Size(max = 100) //Máximo de 100 caracteres
    private String nome;

    @Past //A data deve ser no passado
    private LocalDate dataLancamento;

    private Classificacao classificacao;

    private Long idDesenvolvedora;

}
