package br.com.fiap.porto.model;

public class Concessionaria {
     private int id;
     private String nome;
     private String cnpj;
     private int maximoVeiculos;

    public Concessionaria() {
    }

    public Concessionaria(String nome, String cnpj, int maximoVeiculos) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.maximoVeiculos = maximoVeiculos;
    }

    public Concessionaria(int id, String nome, String cnpj, int maximoVeiculos) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.maximoVeiculos = maximoVeiculos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getMaximoVeiculos() {
        return maximoVeiculos;
    }

    public void setMaximoVeiculos(int maximoVeiculos) {
        this.maximoVeiculos = maximoVeiculos;
    }
}
