package punto13_2;

public class Ticket {
    private Vuelo vuelo;

    public Ticket(Vuelo vuelo){
        this.vuelo = vuelo;
    }

    public int getVuelo() {
        return vuelo.getNroVuelo();
    }

}
