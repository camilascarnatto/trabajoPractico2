package punto8;

public class Revista extends Publicacion{
    private String issn;
    private int anio;
    private int nroPublicacion;
    private int cantidadDeEjemplares;

    public Revista(String nombre, String editor, String telefono, String issn,
                   int anio, int nroPublicacion, int cantidadEjemplares) {
        super(nombre, editor, telefono);
        this.issn = issn;
        this.anio = anio;
        this.nroPublicacion = nroPublicacion;
        this.cantidadDeEjemplares = cantidadEjemplares;
    }

    public int getAnio() {
        return anio;
    }

    public int getNroPublicacion() {
        return nroPublicacion;
    }

    public String getIssn() {
        return issn;
    }
}