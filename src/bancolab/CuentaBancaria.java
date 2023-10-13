package bancolab;

import javax.swing.JOptionPane;

public class CuentaBancaria {

    private int codigo;
    private String name;
    private double saldoCuenta;

    public CuentaBancaria(int codigo, String name) {
        this.codigo = codigo;
        this.name = name;
        saldoCuenta = 500;
    }

    public double getSaldoCuenta() {
        return saldoCuenta;
    }

    public int getCodigo() {
        return codigo;
    }

    void Depositar(double monto) {
        if (monto > 0) {
            saldoCuenta += monto;
        } else {
            System.out.println("El valor es negativo");
            JOptionPane.showMessageDialog(null, "El valor es negativo");
        }
    }

    boolean Retirar(double monto) {
        if (monto > 0 && monto <= saldoCuenta) {
            saldoCuenta -= monto;
            return true;
        }
        return false;
    }

    public void Print() {

        JOptionPane.showMessageDialog(null, "BancoLab{" + "codigo:" + codigo + ", nombre: " + name + ", saldo: Lps. " + saldoCuenta + '}'); ;

    }

}
