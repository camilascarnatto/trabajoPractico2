package punto4;

import java.util.ArrayList;
import java.util.List;

public class Billetera {
    private double saldo;
    private double limiteGiroEnDescubierto;
    private double montoInvertido;
    private List<CompraCredito> comprasCredito;

    public Billetera(double saldoInicial, double limiteGiroEnDescubierto){
        this.saldo = saldoInicial;
        this.limiteGiroEnDescubierto = limiteGiroEnDescubierto;
        this.montoInvertido = 0;
        this.comprasCredito = new ArrayList<>();
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimiteGiroEnDescubierto() {
        return limiteGiroEnDescubierto;
    }

    public double getMontoInvertido() {
        return montoInvertido;
    }

    public List<CompraCredito> getComprasCredito() {
        return comprasCredito;
    }

    public  void realizarInversion(double monto){
        if(montoInvertido > 0){
            throw  new IllegalStateException("Ya tiene una inversion en curso. Debe esperar a que termine");
        }

        if(monto <= 0 || monto > saldo){
            throw  new IllegalStateException("Monto de inversion no valido");
        }

        montoInvertido = monto;
        saldo -= monto;
    }

    public void realizarCompraCredito(double montoCompra){
        if(montoCompra <= 0){
            throw new IllegalArgumentException("Monto de compra invalido");
        }

        //Total a paar con el 5% de recargo
        double montoTotal = montoCompra * 1.05;

        if(montoTotal > limiteCompraDisponible()){
            throw new IllegalStateException("No tiene suficiente limite de compra");
        }

        CompraCredito compra = new CompraCredito(montoCompra);
        comprasCredito.add(compra);

        limiteGiroEnDescubierto -= montoCompra;
    }

    private double limiteCompraDisponible(){
        double totalCompras = 0;
        for (CompraCredito compra : comprasCredito){
            totalCompras += compra.getMonto();
        }
        return limiteGiroEnDescubierto - totalCompras;
    }

    public void realizarPagoCredito(double montoPago){
        if(montoPago <= 0){
            throw new IllegalArgumentException("Monto de pago invalido");
        }

        double deuda = calcularDeudaTotal();

        if(montoPago > deuda){
            throw new IllegalStateException("El monto de pago es mayor que el monto de la deuda");
        }

        for(CompraCredito compra : comprasCredito){
            double montoAPagar = Math.min(montoPago, compra.getMonto());
            compra.pagarCompra(montoAPagar);
            montoPago -= montoAPagar;

            if(montoPago == 0){
                break;
            }
        }
    }

    private double calcularDeudaTotal(){
        double deuda  = 0;
        for (CompraCredito compra : comprasCredito){
            if(!compra.isPagada()){
                deuda += compra.getMonto();
            }
        }
        return  deuda;
    }

    public double calcularSaldoDeudor() {
        double deuda = calcularDeudaTotal();

        double saldoDeudor = saldo + deuda;

        return saldoDeudor;
    }

    public void mostrarInformacion() {
        System.out.println("Saldo de la cuenta: $" + saldo);
        System.out.println("Límite de giro en descubierto: $" + limiteGiroEnDescubierto);

        if (montoInvertido > 0) {
            System.out.println("Monto invertido: $" + montoInvertido);
        }

        double limiteCompra = limiteCompraDisponible();
        System.out.println("Monto disponible para compras a crédito: $" + limiteCompra);

        double saldoDeudor = calcularSaldoDeudor();
        if (saldoDeudor > 0) {
            System.out.println("Saldo deudor: $" + saldoDeudor);
        } else if (saldoDeudor < 0) {
            throw new IllegalStateException("Error: Saldo deudor negativo.");
        }
    }




}
