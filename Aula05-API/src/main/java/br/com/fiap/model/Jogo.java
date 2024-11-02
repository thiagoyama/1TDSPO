package br.com.fiap.model;

import lombok.*;

import java.time.LocalDate;

//LOMBOK gera de forma automática o código repetitivo
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Jogo {

    private int id;

    private String nome;

    private LocalDate dataLancamento;

    private Classificacao classificacao;

    private Desenvolvedora desenvolvedora;

}
