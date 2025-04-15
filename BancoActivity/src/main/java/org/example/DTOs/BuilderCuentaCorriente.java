package org.example.DTOs;

public class BuilderCuentaCorriente {
    double saldo;
    double giroDescubierto;

    int numCuenta;

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    public void setGiroDescubierto(double giroDescubierto) {
        this.giroDescubierto = giroDescubierto;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public CuentaCorrienteDTO build(){
        return new CuentaCorrienteDTO(saldo,giroDescubierto, numCuenta);
    }


}
