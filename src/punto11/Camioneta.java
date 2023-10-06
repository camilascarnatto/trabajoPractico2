package punto11;

public class Camioneta extends Vehiculo{
    private float precioAutorizado;

    public Camioneta(String patente, float precioAutorizado) {
        super(patente);
        this.precioAutorizado  = precioAutorizado;
    }

    @Override
    public float calcularPrecioDiario() {
        return super.calcularPrecioDiario() + (600 * precioAutorizado);
    }
}
