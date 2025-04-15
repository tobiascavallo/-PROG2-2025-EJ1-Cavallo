package org.example;

import org.example.DTOs.BuilderCajaAhorro;
import org.example.DTOs.BuilderCuentaCorriente;
import org.example.DTOs.CajaAhorroDTO;
import org.example.Entity.CajaAhorro;
import org.example.Entity.Cuenta;
import org.example.Entity.CuentaCorriente;
import org.example.Service.LogicaCuenta;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args)throws ExecutionException, InterruptedException {
        System.out.println("BIENVENIDO A TU BANCO DE CONFIANZA");
        LogicaCuenta logicaCuenta= new LogicaCuenta();

        for (int a=0;a<10;a++){
            int eleccionRandom= ThreadLocalRandom.current().nextInt(1,3);
            switch (eleccionRandom){
                case 1:
                    BuilderCajaAhorro builderCaja=new BuilderCajaAhorro();
                    builderCaja.setSaldo(ThreadLocalRandom.current().nextInt(50000,100000));
                    builderCaja.setNumCuenta(a);
                    CajaAhorro caja= new CajaAhorro(builderCaja.build());
                    logicaCuenta.getCuentas().add(caja);
                    break;
                case 2:
                    BuilderCuentaCorriente builderCuenta= new BuilderCuentaCorriente();
                    builderCuenta.setGiroDescubierto(ThreadLocalRandom.current().nextInt(50000,100000));
                    builderCuenta.setSaldo(ThreadLocalRandom.current().nextInt(50000,100000));
                    builderCuenta.setNumCuenta(a);
                    CuentaCorriente cuenta=new CuentaCorriente(builderCuenta.build());
                    logicaCuenta.getCuentas().add(cuenta);
                    break;
            }
        }
        System.out.println("Se han creado 10 distintos objetos de cuenta");
        for (int i=0; i<10000;i++){
           logicaCuenta.agregarSaldo(ThreadLocalRandom.current().nextInt(0,10),ThreadLocalRandom.current().nextInt(10000,50000));
           logicaCuenta.quitarSaldo(ThreadLocalRandom.current().nextInt(0,10),ThreadLocalRandom.current().nextInt(10000,50000));
        }
        System.out.println("se han realizado 10000 movimiento en total");
        List<Cuenta> cuentas= logicaCuenta.getCuentas();
        for (Cuenta c : cuentas){
            System.out.println("Cuenta: "+ c.getNumCuenta());
            System.out.println("Saldo: "+ c.getSaldo());
            System.out.println("Cantidad de Operaciones: "+c.getOperaciones());
        }


    }
}
