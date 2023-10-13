package bancolab;

import javax.swing.JOptionPane;

public class Banco {

    private CuentaBancaria[] cuentas;
    private static final double tasaInteres = 0.05;
//    private int numCuentas;

    public Banco(int capacidad) {
        cuentas = new CuentaBancaria[capacidad];
//        numCuentas = 0;
    }

//REVISADO
    public CuentaBancaria Buscar(int codigo) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta != null && cuenta.getCodigo() == codigo) {
                return cuenta;
            }
        }
        return null;
//        for (int i = 0; i < cuentas.length; i++) {
//            if (cuentas!=null&&cuentas[i].getCodigo() == codigo) {
//                return cuentas[i];
//            }
//        }
//        return null;
    }
//REVISADO

    public boolean Agregar(int codigo, String nombre) {

        if (Buscar(codigo) != null) {
            System.out.println("ya existe el codigo");
            return false;
        }

        for (int pos = 0; pos < cuentas.length; pos++) {
            if (cuentas[pos] == null) {
                CuentaBancaria nuevaCuenta = new CuentaBancaria(codigo, nombre);
                cuentas[pos] = nuevaCuenta;
                System.out.println("Se agregó");
                return true;
            }
        }

        return false;
    }

    //REVISADO
    public void Transferir(int CodOrigen, int CodDestino, double monto) {
        CuentaBancaria cuentaOrigen = Buscar(CodOrigen);
        CuentaBancaria cuentaDestino = Buscar(CodDestino);

        if (cuentaOrigen != null && cuentaDestino != null) {
            if (cuentaOrigen.Retirar(monto)) {
                cuentaDestino.Depositar(monto);
                System.out.println("Se transfirio");
                JOptionPane.showMessageDialog(null, "¡Transferencia Exitosa!");
            } else {
                System.out.println(" no se pudo transferir");
                JOptionPane.showMessageDialog(null, "¡No se pudo realizar la transferencia!");
            }
        } else {
            System.out.println("no se hallo una o dos de las cuentas");
            JOptionPane.showMessageDialog(null, "¡No se pudo hallar una o dos de las cuentas!");
        }
    }

    //REVISADO
    public void Intereses() {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta != null) {
                double intereses = cuenta.getSaldoCuenta() * tasaInteres;
                cuenta.Depositar(intereses);
            }
        }
    }
    
    //REVISADO
    public void Lista(double monto) {
        for (int pos = 0; pos < cuentas.length; pos++) {
            CuentaBancaria cuenta = cuentas[pos];
            if (cuenta.getSaldoCuenta() >= monto) {
                cuenta.Print();
            }
        }
    }
}
