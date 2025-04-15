package org.example.Service;
import org.example.Entity.Cuenta;
import org.example.Entity.IGestionSaldo;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class LogicaCuenta {
    private List<Cuenta> cuentas = new ArrayList<Cuenta>();


    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public boolean agregarSaldo(int nroCuenta, double montoAgregar) throws ExecutionException, InterruptedException {
        long startMethod = System.nanoTime();

        List<CompletableFuture<Void>> futureList = new ArrayList<CompletableFuture<Void>>();

        for (Cuenta c : cuentas) {
            if (c.getNumCuenta() == nroCuenta) {
                CompletableFuture<Void> cf = CompletableFuture.supplyAsync(new Supplier<Void>() {
                    @Override
                    public Void get() {
                        IGestionSaldo gestionSaldo = (IGestionSaldo) c;
                        gestionSaldo.agregarSaldo(montoAgregar);
                        return null;
                    }
                });
                futureList.add(cf);

            }
        }
        if (futureList != null) {
            CompletableFuture<Void> allDone = CompletableFuture.allOf(futureList.toArray(new CompletableFuture[futureList.size()]));
            allDone.join();
            long end=System.nanoTime();
            System.out.println("Saldo agregado correctamente saldo a la cuenta " + nroCuenta);
            System.out.println("tiempo de ejecucion: "+ (end-startMethod)+" ms");
            return true;
        }

        return false;
    }



    public boolean quitarSaldo(int numCuenta, double monto){
        long startMethod = System.nanoTime();

        List<CompletableFuture<Void>> futureList = new ArrayList<CompletableFuture<Void>>();

        for (Cuenta c : cuentas) {
            if (c.getNumCuenta() == numCuenta) {
                CompletableFuture<Void> cf = CompletableFuture.supplyAsync(new Supplier<Void>() {
                    @Override
                    public Void get() {
                        IGestionSaldo gestionSaldo = (IGestionSaldo) c;
                        gestionSaldo.quitarSaldo(monto);
                        return null;
                    }
                });
                futureList.add(cf);

            }
        }
        if (futureList != null) {
            CompletableFuture<Void> allDone = CompletableFuture.allOf(futureList.toArray(new CompletableFuture[futureList.size()]));
            allDone.join();
            long end=System.nanoTime();
            System.out.println("Saldo quitado correctamente saldo de la cuenta " + numCuenta);
            System.out.println("tiempo de ejecucion: "+ (end-startMethod)+" ms");
            return true;
        }
        return true;
    }

    public double consultarSaldo(int numCuenta) {
        long startMethod = System.nanoTime();

        List<CompletableFuture<Double>> futureList = new ArrayList<CompletableFuture<Double>>();

        for (Cuenta c : cuentas) {
            if (c.getNumCuenta() == numCuenta) {
                CompletableFuture<Double> cf = CompletableFuture.supplyAsync(new Supplier<Double>() {
                    @Override
                    public Double get() {
                        IGestionSaldo gestionSaldo = (IGestionSaldo) c;
                        return gestionSaldo.getSaldo();
                    }
                });
                futureList.add(cf);

            }
        }
        if (futureList != null) {
            CompletableFuture<Void> allDone = CompletableFuture.allOf(futureList.toArray(new CompletableFuture[futureList.size()]));
            allDone.join();
            long end=System.nanoTime();
            System.out.println("Su saldo es: $"+ futureList.get(0).join());
            System.out.println("tiempo de ejecucion: "+ (end-startMethod)+" ms");
        }

        return futureList.get(0).join();

    }
}
