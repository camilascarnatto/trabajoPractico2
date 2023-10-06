package punto12;

import java.util.ArrayList;

public class Compra {
    private static int cantidadCompras = 0;
    private int nroDeCompra;
    private double montoAPagar;
    private double monto;
    private double interes;
    private static final double RECARGO_FIJO = 5;
    private ArrayList<Double> pagos = new ArrayList<>();
    private boolean estado;

    public Compra(double monto){
        cantidadCompras++;
        nroDeCompra = cantidadCompras;
        this.monto = monto;
        this.interes = (monto * RECARGO_FIJO / 100);
        this.montoAPagar = (monto + (monto * RECARGO_FIJO / 100));
        this.estado = false;
    }

    //Devuelve el resto del monto a pagar sin intereses
    public double realizarPago(double montoQueMePagan){
        montoAPagar -= montoQueMePagan;
        monto -= montoQueMePagan - (montoQueMePagan * RECARGO_FIJO / 100);
        interes -= montoQueMePagan * RECARGO_FIJO / 100;
        pagos.add(montoQueMePagan);
        if (montoAPagar == 0) estado = true;
        return monto;
    }
    public int getNroDeCompra() {
        return nroDeCompra;
    }

    public double getMonto() {
        return monto;
    }

    public double getMontoAPagar() {
        return montoAPagar;
    }

}
