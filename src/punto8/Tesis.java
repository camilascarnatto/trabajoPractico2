package punto8;

public class Tesis extends Publicacion{
    private Autor autor;
    private int mes;
    private int anio;

    public Tesis(String nombre, String editor, String telefono,Autor autor,
                 int mes, int anio) {
        super(nombre, editor, telefono);
        this.autor = autor;
        this.mes = mes;
        this.anio = anio;
    }

    public String getAutor() {
        return autor.getNombre() + " " + autor.getApellido();
    }

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }
}