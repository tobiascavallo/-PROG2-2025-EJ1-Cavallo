package Entity;

public class Cuenta {
    protected double saldo;
    protected int catOperaciones;
    protected int numCuenta;

    public Cuenta(double saldo, int catOperaciones){
        this.saldo=saldo;
        this.catOperaciones=catOperaciones;
    }
}
