package punto13_1;

public class Pasajero extends Persona{
    public int nroPasajero;

    public Pasajero(String nombre, String telefono, String direccion,
                    int nroPasajero) {
        super(nombre, telefono, direccion);
        this.nroPasajero = nroPasajero;
    }

    public int getNroPasajero() {
        return nroPasajero;
    }

}
