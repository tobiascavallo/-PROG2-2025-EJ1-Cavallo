package org.example.Service;
import org.example.Entity.Cuenta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LogicaCuenta {
    private static volatile LogicaCuenta logica;
    private List<Cuenta> cuentas = Collections.synchronizedList(new ArrayList<>());

    private LogicaCuenta(){}

    public static LogicaCuenta getInstance(){
        if(logica == null){
            synchronized (LogicaCuenta.class){
                if(logica == null){
                    logica = new LogicaCuenta();
                }
            }
        }
        return logica;
    }

    public boolean agregarSaldo(int numCuenta, double saldoAgregar){
        synchronized (cuentas) {
            for (Cuenta c : cuentas) {
                if (c.getNumCuenta() == numCuenta) {
                    c.agregarSaldo(saldoAgregar);
                }
            }
        }
        return true;
    }

    public boolean quitarSaldo(int numCuenta, double saldoQuitar){
        synchronized (cuentas){
            for (Cuenta c : cuentas){
                if (c.getNumCuenta()==numCuenta){
                    c.quitarSaldo(saldoQuitar);
                    return true;
                }
            }
        }
        return false;
    }

    public double consultarSaldo(int numCuenta){
        synchronized (cuentas){
            for (Cuenta c: cuentas){
                if(c.getNumCuenta()==numCuenta){
                    return c.getSaldo();
                }
            }
        }
        return 0;
    }

    public boolean agregarCuenta(Cuenta c){
        cuentas.add(c);
        return true;
    }
}



