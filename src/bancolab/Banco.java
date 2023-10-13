package bancolab;

public class Banco {
    
    private CuentaBancaria[] cuentas;
    private static final double tasaInteres = 0.05; 
    private int numCuentas;

    public Banco(int capacidad) {
        cuentas = new CuentaBancaria[capacidad];
        numCuentas = 0;
    }

    public CuentaBancaria buscar(int codigo) {
        for (int i = 0; i < cuentas.length; i++) {
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
            double interesMensual = cuenta.getSaldoCuenta() * tasaInteres;
            cuenta.Depositar(interesMensual);
        }
    }

    public void lista(double monto) {
        for (int i = 0; i < numCuentas; i++) {
            CuentaBancaria cuenta = cuentas[i];
            if (cuenta.getSaldoCuenta() >= monto) {
                System.out.println(cuenta.toString());
            }
        }
    }
}

