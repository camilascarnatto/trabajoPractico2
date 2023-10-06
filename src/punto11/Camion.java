package punto11;

public class Camion extends Vehiculo{
    private static final float precioFijo = 100000;
    private static final float precioMayorA30Dias = 75000;
    private float precioBase = 0;


    public Camion(String patente) {
        super(patente);
    }

    @Override
    public float calcularPrecio(int dias) {
        if(dias < 30) {
            return dias * precioFijo;
        }else return dias * precioMayorA30Dias;
    }

    @Override
    public float calcularPrecioDiario() {
        return precioFijo;
    }
}
