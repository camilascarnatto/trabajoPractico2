package punto2;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String identificacion;
    private String contacto;
    private List<PaqueteDeTurismo> compras;

    public Cliente(String nombre, String identificacion, String contacto) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.contacto = contacto;
        this.compras = new ArrayList<>();
    }

    public void realizarCompra(PaqueteDeTurismo paqueteDeTurismo) {
        compras.add(paqueteDeTurismo);
    }

    public List<PaqueteDeTurismo> getCompras() {
        return compras;
    }

    public String getNombre() {
        return nombre;
    }


    public String getIdentificacion() {
        return identificacion;
    }

}
