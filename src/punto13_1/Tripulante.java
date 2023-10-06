package punto13_1;

import java.util.ArrayList;

public class Tripulante extends Persona{
    private String cargo;
    private ArrayList<ReciboDeSueldo> recibos;
    public Tripulante(String nombre, String telefono, String direccion,
                      String cargo) {
        super(nombre, telefono, direccion);
        this.cargo = cargo;
        recibos = new ArrayList<>();
    }

    public void agregarRecibo(ReciboDeSueldo reciboSueldo){
        recibos.add(reciboSueldo);
    }

    public String getCargo() {
        return cargo;
    }

}
