package punto8;

public abstract class Publicacion {
    private String nombre;
    private String editor;
    private String telefono;

    public Publicacion(String nombre, String editor, String telefono){
        this.nombre = nombre;
        this.editor = editor;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEditor() {
        return editor;
    }

    public String getTelefono() {
        return telefono;
    }
}
