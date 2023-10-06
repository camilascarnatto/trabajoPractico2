package punto1;

public class Actividad {
    private String descripcion;
    private TipoSuscripcion tipoSuscripcion;

    public Actividad(String nombre, TipoSuscripcion tipo){
        this.descripcion = nombre;
        this.tipoSuscripcion = tipo;

    }

    public String getNombre() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public TipoSuscripcion getSuscripcion() {
        return tipoSuscripcion;
    }
}
