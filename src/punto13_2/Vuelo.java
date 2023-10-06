package punto13_2;

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

    public boolean agregarMiembro(Persona persona){
        boolean res = false;
        for (Persona miembro : miembrosVuelo){
            if (miembro.getDni().equals(persona.getDni())){
                return false;
            }
        }
        persona.asignarRol(this);
        miembrosVuelo.add(persona);
        return res;
    }

    public boolean agregarMiembro(Persona persona, String cargo){
        boolean res = false;
        for (Persona miembro : miembrosVuelo){
            if (miembro.getDni().equals(persona.getDni())){
                return false;
            }
        }
        persona.asignarRol(cargo, nroVuelo);
        miembrosVuelo.add(persona);
        return res;
    }

}
