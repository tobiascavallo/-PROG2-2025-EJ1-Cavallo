package org.example.Entity;

public abstract class Cuenta implements IGestionSaldo{
    protected double saldo;
    protected int catOperaciones=0;
    protected int numCuenta;

    public Cuenta(double saldo, int numCuenta){
        this.saldo=saldo;
        this.numCuenta=numCuenta;
    }
    public int getNumCuenta(){
        return numCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getOperaciones() {
        return catOperaciones;
    }

}
