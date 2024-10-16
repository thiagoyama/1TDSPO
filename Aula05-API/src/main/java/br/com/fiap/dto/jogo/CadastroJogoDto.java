package br.com.fiap.dto.jogo;

import br.com.fiap.model.Classificacao;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

//Define os dados utilizados para o cadastro
@Setter @Getter
public class CadastroJogoDto {

    private String nome;

    private LocalDate dataLancamento;

    private Classificacao classificacao;

}
