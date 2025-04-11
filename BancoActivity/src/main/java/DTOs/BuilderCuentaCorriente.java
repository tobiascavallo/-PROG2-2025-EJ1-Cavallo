package DTOs;

import Entity.CuentaCorriente;

public class BuilderCuentaCorriente {
    double saldo;
    double giroDescubierto;
    int cantOeraciones;

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setCantOeraciones(int cantOeraciones) {
        this.cantOeraciones = cantOeraciones;
    }

    public void setGiroDescubierto(double giroDescubierto) {
        this.giroDescubierto = giroDescubierto;
    }

    public CuentaCorrienteDTO build(){
        return new CuentaCorrienteDTO(saldo,giroDescubierto,cantOeraciones);
    }


}
