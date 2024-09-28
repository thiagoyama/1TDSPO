package br.com.fiap.porto.model;

public class Carro {

    private int id;
    private String modelo;
    private String placa;
    private float motor;
    private boolean automatico;

    private Concessionaria concessionaria;

    public Carro(String modelo, String placa, float motor, boolean automatico) {
        this.modelo = modelo;
        this.placa = placa;
        this.motor = motor;
        this.automatico = automatico;
    }

    public Carro(int id, String modelo, String placa, float motor, boolean automatico) {
        this.id = id;
        this.modelo = modelo;
        this.placa = placa;
        this.motor = motor;
        this.automatico = automatico;
    }

    public Carro(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public float getMotor() {
        return motor;
    }

    public void setMotor(float motor) {
        this.motor = motor;
    }

    public boolean isAutomatico() {
        return automatico;
    }

    public void setAutomatico(boolean automatico) {
        this.automatico = automatico;
    }
}
