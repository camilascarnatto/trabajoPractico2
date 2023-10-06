package punto13_2;

import java.util.ArrayList;

public class Pasajero extends Rol{
    public int nroPasajero;
    public static int cantPasajeros = 0;
    private ArrayList<Ticket> tickets = new ArrayList<>();

    public Pasajero(Vuelo vuelo) {
        super(vuelo.getNroVuelo());
        cantPasajeros++;
        nroPasajero = cantPasajeros;
        setRol("Pasajero");
        Ticket ticket = new Ticket(vuelo);
        tickets.add(ticket);
    }

    public int getNroPasajero() {
        return nroPasajero;
    }

}
