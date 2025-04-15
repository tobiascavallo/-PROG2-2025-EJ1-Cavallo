package org.example.DTOs;

public class CuentaCorrienteDTO {
    double saldo;
    double giroDescubierto;
    int numCuenta;

    public double getGiroDescubierto() {
        return giroDescubierto;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public CuentaCorrienteDTO(double saldo, double giroDescubierto, int numCuenta){
        this.giroDescubierto=giroDescubierto;
        this.saldo=saldo;
        this.numCuenta=numCuenta;
    }
}
