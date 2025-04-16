package org.example.Entity;

import org.example.DTOs.CajaAhorroDTO;

public  class CajaAhorro extends Cuenta {

    public CajaAhorro(CajaAhorroDTO caja) {
        super(caja.getSaldo(), caja.getNumCuenta());
    }

    @Override
    public synchronized boolean agregarSaldo(double monto) {
        saldo += monto;
        catOperaciones++;
        return false;
    }

    @Override
    public synchronized boolean quitarSaldo(double monto) {
        if (saldo >= monto) {
            saldo -= monto;
            catOperaciones++;
            return true;
        } else {
            return false;
        }
    }
}
