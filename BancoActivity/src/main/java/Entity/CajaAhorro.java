package Entity;

public  class CajaAhorro extends Cuenta implements IGestionSaldo{

    public CajaAhorro(double saldo, int catOperaciones) {
        super(saldo, catOperaciones);
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
}
