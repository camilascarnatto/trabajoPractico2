package punto12;

public class CuentaNormal extends Cuenta{

    private double limiteGiroDescubierto;
    private double giroDescubierto;

    public CuentaNormal(double saldo, double limiteGiroDescubierto) {
        super(saldo);
        this.limiteGiroDescubierto = limiteGiroDescubierto;
        giroDescubierto = 0;
    }
    public double getGiroDescubierto() {
        return giroDescubierto;
    }

    public double getLimiteGiroDescubierto() {
        return limiteGiroDescubierto;
    }

    public boolean gastar(double monto) {
        boolean res = false;
        if ((getSaldo() + (limiteGiroDescubierto-giroDescubierto)) >= monto) {
            if (getSaldo() < monto) {
                if(isPrecancelarInversion()){
                    recuperarInversion();
                    if (getSaldo() < monto){
                        giroDescubierto += monto - getSaldo();
                        setSaldo(0);
                    } else {
                        modificarSaldo(-monto);
                    }
                }
            } else {
                modificarSaldo(-monto);
            }
            res = true;
        }
        return res;
    }

    public void depositar(double monto) {
        if(giroDescubierto > 0){
            if (giroDescubierto >= monto){
                giroDescubierto -= monto;
            } else {
                modificarSaldo(monto - giroDescubierto);
                giroDescubierto = 0;
            }
        } else {
            modificarSaldo(monto);
        }
    }

}
