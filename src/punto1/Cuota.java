package punto1;

public class Cuota {
    private  double monto;
    private boolean pagada;

    public Cuota(double monto){
        this.monto = monto;
        this.pagada = false;
    }

    public void pagar(){
        pagada  = true;
    }
}
