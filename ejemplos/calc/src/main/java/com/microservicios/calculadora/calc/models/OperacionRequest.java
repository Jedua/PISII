package com.microservicios.calculadora.calc.models;

public class OperacionRequest {
    private int numeroA;
    private int numeroB;

    // Getters y Setters
    public int getNumeroA() {
        return numeroA;
    }

    public void setNumeroA(int numeroA) {
        this.numeroA = numeroA;
    }

    public int getNumeroB() {
        return numeroB;
    }

    public void setNumeroB(int numeroB) {
        this.numeroB = numeroB;
    }
}