package bancolab;

import javax.swing.JOptionPane;

public class Banco {

    private CuentaBancaria[] cuentas;
    private static final double tasaInteres = 0.05; // Tasa de interés constante

    public Banco(int numCuentas) {
        cuentas = new CuentaBancaria[numCuentas];
    }

    public String obtenerInfoCuentas(double monto) {
        StringBuilder info = new StringBuilder();

        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getSaldo() >= monto) {
                String cuentaInfo = "Código: " + cuenta.getCodigo()
                        + ", Nombre: " + cuenta.getNombreCliente()
                        + ", Saldo: " + cuenta.getSaldo() + "\n";
                info.append(cuentaInfo);
            }
        }

        return info.toString();
    }

    public CuentaBancaria buscar(int codigo) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta != null && cuenta.getCodigo() == codigo) {
                return cuenta;
            }
        }
        return null;
    }

    public boolean agregar(int codigo, String nombre) {
        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i] == null) {
                // Verificar si el código es único
                boolean codigoUnico = true;
                for (CuentaBancaria cuenta : cuentas) {
                    if (cuenta != null && cuenta.getCodigo() == codigo) {
                        codigoUnico = false;
                        break;
                    }
                }
                if (codigoUnico) {
                    cuentas[i] = new CuentaBancaria(codigo, nombre);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean transferir(int codigoOrigen, int codigoDestino, double monto) {
        CuentaBancaria cuentaOrigen = buscar(codigoOrigen);
        CuentaBancaria cuentaDestino = buscar(codigoDestino);

        if (cuentaOrigen != null && cuentaDestino != null) {
            if (cuentaOrigen.retirar(monto)) {
                cuentaDestino.depositar(monto);
                return true;
            }
        }
        return false;
    }

    public void intereses() {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta != null) {
                double interesesMensuales = cuenta.getSaldo() * tasaInteres;
                cuenta.depositar(interesesMensuales);
            }
        }
    }

    public void lista(double monto) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta != null && cuenta.getSaldo() >= monto) {
                cuenta.print();
            }
        }
    }
}
