package punto5;

public class CompraCredito {
    private double monto;
    private  double montoRestante;
    private boolean pagada;

    public CompraCredito(double monto){
        this.monto = monto;
        this.montoRestante = monto;
        this.pagada = false;
    }

    public double getMonto() {
        return monto;
    }

    public double getMontoRestante() {
        return montoRestante;
    }

    public boolean isPagada() {
        return pagada;
    }

    public void pagarCompra(double monto){
        if(monto <= 0 || monto > montoRestante){
            throw new IllegalArgumentException("Monto de pago invalido");
        }

        montoRestante -= monto;

        if(montoRestante == 0){
            pagada = true;
        }

    }
}
