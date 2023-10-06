package punto12;

import java.util.ArrayList;

public class CuentaCredito {
    private double limite;
    private ArrayList<Compra> compras;

    public CuentaCredito(double limite) {
        this.limite = limite;
        this.compras = new ArrayList<>();
    }

    //Devuelve -1 si la compra no fue exitosa y el numero de compra en caso de
    //que se haya podido realizar
    public int comprar(double monto) {
        if (monto <= limite){
            Compra compra = new Compra(monto);
            limite -= compra.getMonto();
            compras.add(compra);
            return compra.getNroDeCompra();
        }
        return -1;
    }

    public boolean pagar(double monto, int nroCompra) {
        for (Compra compra : compras){
            if (compra.getNroDeCompra() == nroCompra){
                if (monto <= compra.getMontoAPagar()){
                    limite += compra.realizarPago(monto);
                }
            }
        }
        return false;
    }

    public double getSaldoDeudorCompra(int nroCompra) {
        for (Compra compra : compras){
            if (compra.getNroDeCompra() == nroCompra){
                compra.getMontoAPagar();
            }
        }
        return -1;
    }

    public double getSaldoDeudor() {
        double deuda = 0;
        for (Compra compra : compras){
            deuda += compra.getMontoAPagar();
        }
        return deuda;
    }

    public double getLimite() {
        return limite;
    }

}
