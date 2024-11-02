package br.com.fiap.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Desenvolvedora {

    private Long id;

    private String nome;

    public Desenvolvedora(Long id) {
        this.id = id;
    }
}
