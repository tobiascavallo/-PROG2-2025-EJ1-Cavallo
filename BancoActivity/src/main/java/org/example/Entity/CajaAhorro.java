package org.example.Entity;

import org.example.DTOs.CajaAhorroDTO;

public  class CajaAhorro extends Cuenta implements IGestionSaldo {

    public CajaAhorro(CajaAhorroDTO caja) {
        super(caja.getSaldo(), caja.getNumCuenta());
    }

    @Override
    public synchronized boolean agregarSaldo(double monto) {
        saldo+=monto;
        catOperaciones++;
        return false;
    }

    @Override
    public synchronized boolean quitarSaldo(double monto) {
        if (saldo>=monto){
            saldo-=monto;
            catOperaciones++;
            return true;
        }else {
            return false;
        }
    }

    @Override
    public synchronized double getSaldo() {
        catOperaciones++;
        return this.saldo;
    }

    @Override
    public synchronized int getOperaciones() {
        return catOperaciones;
    }

    @Override
    public synchronized int getNumCuenta(){
        return numCuenta;
    }
}
