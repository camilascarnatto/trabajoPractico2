package punto13_1;

import java.util.ArrayList;

public class Vuelo {
    private int nroVuelo;
    private String origen;
    private String destino;
    private String horario;
    private ArrayList<Persona> miembrosVuelo;

    public Vuelo(int nroVuelo, String origen, String destino,
                 String horario){
        this.destino = destino;
        this.nroVuelo = nroVuelo;
        this.origen = origen;
        this.horario = horario;
        miembrosVuelo = new ArrayList<>();
    }

    public int getNroVuelo() {
        return nroVuelo;
    }

    public String agregarMiembro(Pasajero pasajero, Ticket ticket){
        if (ticket.getVuelo() == nroVuelo &&
                ticket.getPasajero() == pasajero.getNroPasajero()){
            miembrosVuelo.add(pasajero);
            return "Se agrego al pasajero " + pasajero.getNombre() + " al vuelo";
        }
        return "No se pudo agregar al pasajero";
    }

    public String agregarMiembro(Tripulante tripulante){
        miembrosVuelo.add(tripulante);
        return  "Se agrego al tripulante " + tripulante.getNombre() + " al vuelo";
    }

}
