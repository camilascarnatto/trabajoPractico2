package punto1;

import java.util.List;

public class Suscripcion {
    private TipoSuscripcion tipo;
    private double precio;
    private List<Actividad> actividades;

    public Suscripcion(TipoSuscripcion tipo, double precio, List<Actividad> actividades){
        this.tipo = tipo;
        this.precio = precio;
        this.actividades = actividades;
    }

    public boolean tieneAcceso(Actividad actividad){
        return actividades.contains(actividad);
    }

    public double getPrecio() {
        return precio;
    }

    public TipoSuscripcion getTipo() {
        return tipo;
    }
}
