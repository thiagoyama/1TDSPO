package br.com.fiap.dto.jogo;

import br.com.fiap.model.Classificacao;
import br.com.fiap.model.Desenvolvedora;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class DetalhesJogoDto {

    private int id;

    private String nome;

    private LocalDate dataLancamento;

    private Classificacao classificacao;

    private Desenvolvedora desenvolvedora;

}
