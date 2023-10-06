package punto8;

import java.util.ArrayList;

public class Libro extends Publicacion {
    private String isbn;
    private ArrayList<Ejemplar> ejemplares;
    private ArrayList<Autor> autores;
    private int cantidadPaginas;
    private int cantidadDeEjemplares = 0;

    public Libro(String nombre, String editor, String telefono, Autor autor,
                 String isbn, int cantidadPaginas, int cantidadDeEjemplares) {
        super(nombre, editor, telefono);
        autores = new ArrayList<>();
        ejemplares = new ArrayList<>();
        autores.add(autor);
        this.isbn = isbn;
        this.cantidadPaginas = cantidadPaginas;
        agregarEjemplares(cantidadDeEjemplares);
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public String mostrarEjemplaresPrestados(){
        String res = "EJEMPLARES PRESTADOS:\n";
        for (Ejemplar ejemplar : ejemplares){
            if (ejemplar.estaPrestado()){
                res += "Ejemplar Nº " + ejemplar.getNroEjemplar() + "\n";
            }
        }
        return res;
    }

    public int cantEjemplaresDisponibles(){
        int i = 0;
        for (Ejemplar ejemplar : ejemplares){
            if (!ejemplar.estaPrestado()){
                i++;
            }
        }
        return i;
    }

    public int cantEjemplaresPrestados(){
        int i = 0;
        for (Ejemplar ejemplar : ejemplares){
            if (ejemplar.estaPrestado()){
                i++;
            }
        }
        return i;
    }

    public boolean agregarAutor(Autor autor){
        for (Autor autor1 : autores){
            if (autor1.equals(autor)){
                return false;
            }
        }
        autores.add(autor);
        return true;
    }

    public String getAutores() {
        String res = "";
        for (Autor autor : autores){
            res += autor.getNombre() + " " + autor.getApellido() + ", ";
        }
        return res;
    }

    public String toString(){
        return "El libro \u001B[36m" + getNombre() + "\u001B[0m creado por el autor \u001B[36m" + getAutores() +
                "\u001B[0m tiene \u001B[36m" + cantidadPaginas + "\u001B[0m páginas, quedan \u001B[36m" +
                cantEjemplaresDisponibles() + "\u001B[0m ejemplares disponibles y se prestaron \u001B[36m" +
                cantEjemplaresPrestados() + "\u001B[0m ejemplares";
    }

    public void agregarEjemplares(int cantidadNuevosEjemplares){
        for (int i = 1; i <= cantidadNuevosEjemplares; i++){
            cantidadDeEjemplares++;
            Ejemplar ejemplar = new Ejemplar(cantidadDeEjemplares);
            ejemplares.add(ejemplar);
        }
    }

    public boolean prestarLibro(int nroEjemplar){
        boolean sePuedePrestar = false;
        if (cantEjemplaresDisponibles() > 1){
            for (Ejemplar ejemplar : ejemplares){
                if (ejemplar.getNroEjemplar() == nroEjemplar
                        && (!ejemplar.estaPrestado())){
                    ejemplar.prestar();
                    sePuedePrestar = true;
                }
            }
        }
        return sePuedePrestar;
    }

    public boolean devolverLibro(int nroEjemplar){
        boolean seDevuelve = false;
        if (cantEjemplaresPrestados() > 0){
            for (Ejemplar ejemplar : ejemplares){
                if (ejemplar.getNroEjemplar() == nroEjemplar &&
                        ejemplar.estaPrestado()){
                    ejemplar.devolver();
                    seDevuelve = true;
                }
            }
        }
        return seDevuelve;
    }
}
