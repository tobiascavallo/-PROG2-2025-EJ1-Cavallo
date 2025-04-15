package org.example.DTOs;

public class BuilderCajaAhorro {
    double saldo;
    int numCuenta;

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public CajaAhorroDTO build(){
        return new CajaAhorroDTO(saldo, numCuenta);
    }
}
