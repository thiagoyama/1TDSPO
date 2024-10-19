package br.com.fiap.dto.jogo;

import br.com.fiap.model.Classificacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class AtualizacaoJogoDto {

    @NotBlank
    @Size(max = 100)
    private String nome;

    @Past
    private LocalDate dataLancamento;

    private Classificacao classificacao;

}
