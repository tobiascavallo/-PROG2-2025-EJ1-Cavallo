package Entity;

public  class CuentaCorriente extends Cuenta implements IGestionSaldo{
   public  double giroDescubierto;

   public CuentaCorriente(double saldo, int cantOperaciones){
       super(saldo,cantOperaciones);
   }
    @Override
    public synchronized boolean agregarSaldo(double monto) {
       saldo=saldo+monto;
       catOperaciones++;
        return true;
    }

    @Override
    public synchronized boolean quitarSaldo(double monto) {
       saldo= saldo-monto;
       if(saldo<=giroDescubierto){
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
}
