package bancolab;

import javax.swing.JOptionPane;

public class CuentaBancaria {

    private int codigo;
    private String nombreCliente;
    private double saldo;

    public CuentaBancaria(int codigo, String nombreCliente) {
        this.codigo = codigo;
        this.nombreCliente = nombreCliente;
        this.saldo = 500; // Saldo inicial por defecto
    }

    public int getCodigo() {
        return codigo;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }
    

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
        }
    }

    public boolean retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            return true;
        }
        return false;
    }
     public void print() {
        System.out.println("Código: " + codigo + ", Nombre del cliente: " + nombreCliente + ", Saldo: " + saldo);
    }

}
