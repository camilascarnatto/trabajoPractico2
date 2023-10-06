package punto12;

import java.time.LocalDate;

public abstract class Cuenta {
    private double saldo;
    private double saldoInvertido;
    private static final double INTERES_POR_INVERSION = 0.4;
    private static final double PLAZO_DIAS_INVERSION = 120;
    private LocalDate fechaInversion;
    private boolean precancelarInversion;

    public Cuenta(double saldo){
        this.saldo = saldo;
        saldoInvertido = 0;
        fechaInversion = null;
        precancelarInversion = false;
    }
    public static double getInteresPorInversion() {
        return INTERES_POR_INVERSION;
    }

    public static double getPlazoDiasInversion() {
        return PLAZO_DIAS_INVERSION;
    }

    public double getSaldoInvertido() {
        return saldoInvertido;
    }

    public LocalDate getFechaInversion() {
        return fechaInversion;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    protected void modificarSaldo(double monto){
        this.saldo += monto;
    }

    public abstract boolean gastar(double monto);

    public abstract void depositar(double monto);

    public boolean invertir(double monto){
        if(saldo >= monto && saldoInvertido == 0){
            saldoInvertido = monto;
            saldo -= saldoInvertido;
            fechaInversion = LocalDate.now();
            return true;
        }
        return false;
    }

    public void recuperarInversion(){
        if (fechaInversion.plusDays((long)PLAZO_DIAS_INVERSION).isEqual(LocalDate.now()) ||
                fechaInversion.plusDays((long)PLAZO_DIAS_INVERSION).isBefore(LocalDate.now())){
            saldo += saldoInvertido + (saldoInvertido * INTERES_POR_INVERSION);
            saldoInvertido = 0;
        } else if (fechaInversion.plusDays(30).isEqual(LocalDate.now()) ||
                fechaInversion.plusDays(30).isBefore(LocalDate.now())){
            saldo += saldoInvertido + (saldoInvertido * 0.05);
            saldoInvertido = 0;
        } else {
            saldo += saldoInvertido;
            saldoInvertido = 0;
        }
    }

    public boolean isPrecancelarInversion() {
        return precancelarInversion;
    }

    public void activarPrecancelarInversion(){
        precancelarInversion = true;
    }

    public void desactivarPrecancelarInversion(){
        precancelarInversion = false;
    }

    public double getInteresAGanar() {
        if (fechaInversion != null){
            if (fechaInversion.plusDays((long) PLAZO_DIAS_INVERSION).isEqual(LocalDate.now()) ||
                    fechaInversion.plusDays((long) PLAZO_DIAS_INVERSION).isAfter(LocalDate.now())){
                return saldoInvertido * INTERES_POR_INVERSION;
            } else if(fechaInversion.plusDays(30).isEqual(LocalDate.now()) ||
                    fechaInversion.plusDays(30).isAfter(LocalDate.now())){
                return saldoInvertido * 0.05;
            }

        }

        return 0.0d;
    }

}
