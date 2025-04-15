package org.example.DTOs;

public class CajaAhorroDTO {
    double saldo;
    int numCuenta;

    public double getSaldo(){
        return  this.saldo;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public CajaAhorroDTO(double saldo, int numCuenta){
        this.saldo=saldo;
        this.numCuenta=numCuenta;
    }
}
