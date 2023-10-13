/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bancolab;

/**
 *
 * @author nathalia.romero
 */
public class Banco {
    
    private CuentaBancaria[] cuentas;
    private static final double tasaInteres = 0.05; 
    private int numCuentas;

    public Banco(int capacidad) {
        cuentas = new CuentaBancaria[capacidad];
        numCuentas = 0;
    }

    public CuentaBancaria buscar(int codigo) {
        for (int i = 0; i < numCuentas; i++) {
            if (cuentas[i].getCodigo() == codigo) {
                return cuentas[i];
            }
        }
        return null;
    }

    public boolean agregar(int codigo, String nombre) {
        if (numCuentas >= cuentas.length) {
            return false; 
        }

        if (buscar(codigo) != null) {
            return false; 
        }

        CuentaBancaria nuevaCuenta = new CuentaBancaria(codigo, nombre);
        cuentas[numCuentas] = nuevaCuenta;
        numCuentas++;
        return true;
    }

    public void transferir(int origen, int destino, double monto) {
        CuentaBancaria cuentaOrigen = buscar(origen);
        CuentaBancaria cuentaDestino = buscar(destino);

        if (cuentaOrigen == null || cuentaDestino == null) {
           cuentaOrigen.Retirar(monto) ;
           cuentaDestino.Depositar(monto);
        }
    }

    public void calcularIntereses() {
        for (int i = 0; i < numCuentas; i++) {
            CuentaBancaria cuenta = cuentas[i];
            double interesMensual = cuenta.getSaldo() * tasaInteres;
            cuenta.Depositar(interesMensual);
        }
    }

    public void lista(double monto) {
        for (int i = 0; i < numCuentas; i++) {
            CuentaBancaria cuenta = cuentas[i];
            if (cuenta.getSaldo() >= monto) {
                System.out.println(cuenta.toString());
            }
        }
    }
}

