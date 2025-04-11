package DTOs;

public class CuentaCorrienteDTO {
    double saldo;
    double giroDescubierto;
    int cantOeraciones;

    public double getGiroDescubierto() {
        return giroDescubierto;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getCantOeraciones() {
        return cantOeraciones;
    }

    public CuentaCorrienteDTO(double saldo, double giroDescubierto, int cantOeraciones){
        this.cantOeraciones=cantOeraciones;
        this.giroDescubierto=giroDescubierto;
        this.saldo=saldo;
    }
}
