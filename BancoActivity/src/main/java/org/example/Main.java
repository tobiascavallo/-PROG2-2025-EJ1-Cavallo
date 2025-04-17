package org.example;

import org.example.DTOs.BuilderCajaAhorro;
import org.example.DTOs.BuilderCuentaCorriente;
import org.example.DTOs.CajaAhorroDTO;
import org.example.Entity.CajaAhorro;
import org.example.Entity.Cuenta;
import org.example.Entity.CuentaCorriente;
import org.example.Service.LogicaCuenta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args)throws ExecutionException, InterruptedException {
        System.out.println("BIENVENIDO A TU BANCO DE CONFIANZA");
        LogicaCuenta logicaCuenta= LogicaCuenta.getInstance();


        for (int a=0;a<10;a++){
            int eleccionRandom= ThreadLocalRandom.current().nextInt(1,3);
            switch (eleccionRandom){
                case 1:
                    BuilderCajaAhorro builderCaja=new BuilderCajaAhorro();
                    builderCaja.setSaldo(ThreadLocalRandom.current().nextInt(50000,100000));
                    builderCaja.setNumCuenta(a);
                    CajaAhorro caja= new CajaAhorro(builderCaja.build());
                    logicaCuenta.agregarCuenta(caja);
                    break;
                case 2:
                    BuilderCuentaCorriente builderCuenta= new BuilderCuentaCorriente();
                    builderCuenta.setGiroDescubierto(ThreadLocalRandom.current().nextInt(50000,100000));
                    builderCuenta.setSaldo(ThreadLocalRandom.current().nextInt(50000,100000));
                    builderCuenta.setNumCuenta(a);
                    CuentaCorriente cuenta = new CuentaCorriente(builderCuenta.build());
                    logicaCuenta.agregarCuenta(cuenta);
                    break;
            }
        }

        System.out.println("Se han creado 10 distintos objetos de cuenta");

        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<Void>> futures = new ArrayList<Future<Void>>();

        long startMethod= System.currentTimeMillis();
        long start= System.currentTimeMillis();

        for (int i=0; i<10000;i++){
            Future<Void> future = executor.submit(new Callable<Void>() {
                @Override
                public Void call() throws Exception {
                    logicaCuenta.agregarSaldo(ThreadLocalRandom.current().nextInt(0,10),ThreadLocalRandom.current().nextInt(10000,50000));
                    logicaCuenta.quitarSaldo(ThreadLocalRandom.current().nextInt(0,10),ThreadLocalRandom.current().nextInt(10000,50000));
                    return null;
                }
            });
         futures.add(future);
        }
        long end = System.currentTimeMillis();
        System.out.println("tiempo en realizar las 10 mil iteraicones: "+(end-start)+" (ms)");

        for(Future<Void> f:futures){
            try{
                f.get();//espera a q terminen las tareas
            }catch (ExecutionException | InterruptedException e){
                e.printStackTrace();
            }
        }
        executor.shutdown();//apaga el executor
        long endMethod = System.currentTimeMillis();
        System.out.println("tiempo en realizar las 10 mil iteraicones: "+(endMethod-startMethod)+" (ms)");

        System.out.println("se han realizado 10000 movimiento en total");

        for (Cuenta c: logicaCuenta.getCuentas()){
            System.out.println("Tipo de cuenta: " + c.getClass().getSimpleName());
            System.out.println("Cuenta: "+ c.getNumCuenta());
            System.out.println("Saldo: "+ c.getSaldo());
        }

    }
}
