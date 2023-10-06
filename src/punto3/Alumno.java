package punto3;

import java.util.ArrayList;
import java.util.List;


public class Alumno {
    private String nombre;
    private String datosPersonales;
    private String contacto;
    private List<Comision> clasesInscritas;
    private String credencial;

    public Alumno(String nombre, String datosPersonales, String contacto) {
        this.nombre = nombre;
        this.datosPersonales = datosPersonales;
        this.contacto = contacto;
        this.clasesInscritas = new ArrayList<>();
        // Generar credencial
    }

    public void inscribirseEnClase(Comision comision) {
        clasesInscritas.add(comision);
    }

    public void presentarCredencial() {
        // Lógica para presentar la credencial
    }

}
