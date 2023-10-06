package punto14;

public class Cliente {
    private String nombre;
    private String apellido;
    private String mail;
    private String dni;

    public Cliente(String nombre, String apellido,
                   String mail, String dni) {
        this.nombre = nombre;
        this.mail = mail;
        this.apellido = apellido;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

}
