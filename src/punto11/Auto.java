package punto11;

public class Auto extends Vehiculo{
    private int cantidadDeAsientos;
    private boolean esAutoVip;


    public Auto(String patente, int asientos, boolean vip) {
        super(patente);
        this.cantidadDeAsientos = asientos;
        this.esAutoVip = vip;
    }

    @Override
    public float calcularPrecioDiario() {
        if(esAutoVip){
            return super.calcularPrecioDiario() + (cantidadDeAsientos * 500);
        }
        return super.calcularPrecioDiario() + (cantidadDeAsientos * 300);
    }
}
