package org.example.Entity;

import org.example.DTOs.CuentaCorrienteDTO;

public  class CuentaCorriente extends Cuenta  {
   public  double giroDescubierto;
   public int intentosFallidos = 0;

   public CuentaCorriente(CuentaCorrienteDTO cuenta){
       super(cuenta.getSaldo(), cuenta.getNumCuenta());
       this.giroDescubierto=cuenta.getGiroDescubierto();
   }
    @Override
    public synchronized boolean agregarSaldo(double monto) {
       saldo+=monto;
       catOperaciones++;
        return true;
    }

    @Override
    public synchronized boolean quitarSaldo(double monto) {
       if((saldo-monto)>=(-giroDescubierto)){
           saldo -=monto;
           catOperaciones++;
           return true;
       }else {
           intentosFallidos ++;
           System.out.println("no puede quitar esa cantidad porque supera el giro descubierto "+intentosFallidos+" el giro descubierto es de "+ giroDescubierto );
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
