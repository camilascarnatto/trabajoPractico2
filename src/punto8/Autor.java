package punto8;

public class Autor {
    private String nombre;
    private String apellido;

    public Autor(String nombre, String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}
