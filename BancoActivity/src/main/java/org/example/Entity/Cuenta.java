package org.example.Entity;

public class Cuenta implements IGestionSaldo{
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

    @Override
    public boolean agregarSaldo(double monto) {
        return false;
    }

    @Override
    public boolean quitarSaldo(double monto) {
        return false;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getOperaciones() {
        return catOperaciones;
    }

}
