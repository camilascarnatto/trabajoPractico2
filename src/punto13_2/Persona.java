package punto13_2;

import java.util.ArrayList;

public class Persona {
    private String nombre;
    private String telefono;
    private String dni;
    private ArrayList<Rol> roles;

    public Persona(String nombre, String telefono,
                   String dni){
        this.nombre = nombre;
        this.telefono = telefono;
        this.dni = dni;
        roles = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public void asignarRol(Vuelo vuelo) {
        Pasajero pasajero = new Pasajero(vuelo);
        roles.add(pasajero);
    }

    public void asignarRol(String cargo, int nroVuelo) {
        Tripulante tripulante = new Tripulante(cargo, nroVuelo);
        roles.add(tripulante);
    }

    public String obtenerRol(int nroVuelo){
        for (Rol rol : roles){
            if (rol.getNroVuelo() == nroVuelo){
                return rol.getRol();
            }
        }
        return getNombre() + "no es miembro de ese vuelo";
    }

}
