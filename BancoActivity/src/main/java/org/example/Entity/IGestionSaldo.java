package org.example.Entity;

public interface IGestionSaldo {
    boolean agregarSaldo(double monto);
    boolean quitarSaldo(double monto);
    double getSaldo();
    int getOperaciones();
    int getNumCuenta();
}
