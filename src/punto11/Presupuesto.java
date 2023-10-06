package punto11;

public class Presupuesto {
    private int cantDias;
    private float precioTotal;
    private Vehiculo vehiculo;

    public Presupuesto(float precio, Vehiculo vehiculo, int cantDias){
        this.vehiculo = vehiculo;
        this.cantDias  =cantDias;
        this.precioTotal = precio;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public int getCantDias() {
        return cantDias;
    }

    public String toString(){
        return "Presupuesto del vehiculo: " + vehiculo.getPatente() +
                "\n para " + cantDias + " dias, por $" + getPrecioTotal();
    }
}
