package punto5;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Billetera {
    private double saldo;
    private double limiteGiroEnDescubierto;
    private List<CompraCredito> comprasCredito;
    private Inversion inversion;

    public Billetera(double saldoInicial, double limiteGiroEnDescubierto){
        this.saldo = saldoInicial;
        this.limiteGiroEnDescubierto = limiteGiroEnDescubierto;
        this.comprasCredito = new ArrayList<>();
        this.inversion = null;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimiteGiroEnDescubierto() {
        return limiteGiroEnDescubierto;
    }

    /*
    public double getMontoInvertido() {
        return montoInvertido;
    }
     */

    public List<CompraCredito> getComprasCredito() {
        return comprasCredito;
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

        if(saldo > montoCompra){
            cancelarInversionAutomatica();
        }

        CompraCredito compra = new CompraCredito(montoCompra);
        comprasCredito.add(compra);

        limiteGiroEnDescubierto -= montoCompra;
    }

    private  void cancelarInversionAutomatica(){
        if(inversion !=  null){
            inversion.cancelarInversion();
            inversion = null;
        }
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

        return saldo + deuda;
    }


    public void iniciarInversion(double monto) {
        if (inversion != null) {
            throw new IllegalStateException("Ya tiene una inversión en curso. Debe esperar a que termine.");
        }

        if (monto <= 0 || monto > saldo) {
            throw new IllegalArgumentException("Monto de inversión no válido.");
        }

        inversion = new Inversion();
        inversion.iniciarInversion(monto);
        saldo -= monto;
    }

    public void cancelarInversion(){
        if(inversion == null){
            throw new IllegalStateException("No hay ninguna inversion para cancelar");
        }

        double interesDevuelto = inversion.calcularInteresesDevuelto();
        saldo += inversion.getMontoInvertido() + interesDevuelto;
        inversion.cancelarInversion();

        // Actualiza el límite de compra disponible después de cancelar la inversión
        double limiteCompraActualizado = limiteGiroEnDescubierto - calcularTotalCompras();
        limiteGiroEnDescubierto = limiteCompraActualizado;

    }

    private double calcularTotalCompras() {
        double totalCompras = 0;
        for (CompraCredito compra : comprasCredito) {
            totalCompras += compra.getMonto();
        }
        return totalCompras;
    }


    public double calcularInteresesDeInversion() {
        if(inversion.getMontoInvertido() == 0 || inversion.getFechaInicio() == null){
            throw new IllegalStateException("No hay ninguna inversion activa");
        }

        LocalDate fechaActual = LocalDate.now();
        long diasTranscurridos = ChronoUnit.DAYS.between(inversion.getFechaInicio(), fechaActual);
        if(diasTranscurridos < 30){
            return 0;
            //No hay intereses
        }
        return inversion.getMontoInvertido() * 0.05;

    }
}
