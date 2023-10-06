package punto12;

public class CajaDeAhorro extends Cuenta{
    public CajaDeAhorro(double saldo) {
        super(saldo);
    }

    public boolean gastar(double monto) {
        boolean res = false;
        if (getSaldo() >= monto){
            modificarSaldo(-monto);
        } else {
            if(isPrecancelarInversion()){
                recuperarInversion();
                if (getSaldo() > monto){
                    modificarSaldo(-monto);
                }
            }
        }
        return res;
    }

    public void depositar(double monto) {
        if (monto > 0){
            modificarSaldo(monto);
        }
    }

}
