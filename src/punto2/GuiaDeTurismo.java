package punto2;

import java.util.ArrayList;
import java.util.List;

public class GuiaDeTurismo {
    private String nombre;
    private String contacto;
    private List<Excursion> excursiones;

    public GuiaDeTurismo(String nombre, String contacto) {
        this.nombre = nombre;
        this.contacto = contacto;
        this.excursiones = new ArrayList<>();
    }

    public void ofrecerExcursion(Excursion excursion) {
        excursiones.add(excursion);
    }

}
