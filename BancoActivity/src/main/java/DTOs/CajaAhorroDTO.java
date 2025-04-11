package DTOs;

public class CajaAhorroDTO {
    double saldo;
    int cantOperaciones;

    public double getSaldo(){
        return  this.saldo;
    }

    public int getCantOperaciones() {
        return cantOperaciones;
    }

    public CajaAhorroDTO(double saldo, int cantOperaciones){
        this.saldo=saldo;
        this.cantOperaciones=cantOperaciones;
    }
}
