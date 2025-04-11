package DTOs;

public class BuilderCajaAhorro {
    double saldo;
    int cantOperaciones;

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setCantOperaciones(int cantOperaciones) {
        this.cantOperaciones = cantOperaciones;
    }
    public CajaAhorroDTO build(){
        return new CajaAhorroDTO(saldo,cantOperaciones);
    }
}
