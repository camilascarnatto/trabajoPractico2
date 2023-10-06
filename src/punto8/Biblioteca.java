package punto8;

import java.time.LocalDate;
import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Publicacion> publicaciones;
    private ArrayList<Libro> libros;
    private ArrayList<Socio> socios;
    private ArrayList<Prestamo> prestamos;

    public Biblioteca(){
        publicaciones = new ArrayList<>();
        libros = new ArrayList<>();
        socios = new ArrayList<>();
        prestamos = new ArrayList<>();
    }

    public void agregarPublicacion(String titulo,String editor, String telefono,
                                   Autor autor, int cantidadPaginas, String isbn,
                                   int cantidadEjemplares){
        Libro libro = new Libro(titulo,editor,telefono,autor,isbn,cantidadPaginas,cantidadEjemplares);
        libros.add(libro);
    }

    public void agregarPublicacion(String nombre, String editor, String telefono,
                                   Autor autor, int mes, int anio){
        Tesis tesis = new Tesis(nombre,editor,telefono,autor,mes,anio);
        publicaciones.add(tesis);
    }

    public void agregarPublicacion(String nombre, String editor, String telefono, String issn,
                                   int anio, int nroPublicacion, int cantidadEjemplares){
        Revista revista = new Revista(nombre,editor,telefono,issn,anio,nroPublicacion,cantidadEjemplares);
        publicaciones.add(revista);
    }

    public void agregarPublicacion(String nombre, String editor, String telefono,
                                   LocalDate fechaPublicacion){
        Diario diario = new Diario(nombre,editor,telefono,fechaPublicacion);
        publicaciones.add(diario);
    }



    public boolean prestarLibroPorTitulo(String titulo, int nroEjemplar,Socio socio,
                                         int cantDias){
        for (Libro libro : libros){
            if (libro.getNombre().equals(titulo)){
                Prestamo prestamo = new Prestamo(socio,libro,nroEjemplar,cantDias);
                prestamos.add(prestamo);
                socio.agregarPrestamo(prestamo);
                return libro.prestarLibro(nroEjemplar);
            }
        }
        return false;
    }

    public boolean devolverLibroPorTitulo(String titulo, int nroEjemplar){
        for (Libro libro : libros){
            if (libro.getNombre().equals(titulo)){
                return libro.devolverLibro(nroEjemplar);
            }
        }
        return false;
    }

    public boolean prestarLibroPorISBN(String isbn, int nroEjemplar, Socio socio,
                                       int cantDias){
        for (Libro libro : libros){
            if (libro.getIsbn().equals(isbn)){
                Prestamo prestamo = new Prestamo(socio,libro,nroEjemplar,cantDias);
                prestamos.add(prestamo);
                socio.agregarPrestamo(prestamo);
                return libro.prestarLibro(nroEjemplar);
            }
        }
        return false;
    }

    public boolean devolverLibroPorISBN(String isbn, int nroEjemplar){
        for (Libro libro : libros){
            if (libro.getIsbn().equals(isbn)){
                return libro.devolverLibro(nroEjemplar);
            }
        }
        return false;
    }

    public int cantidadEjemplaresDisponibles(String titulo){
        for (Libro libro : libros){
            if (libro.getNombre().equals(titulo)){
                return libro.cantEjemplaresDisponibles();
            }
        }
        return -1;
    }

    public String ejemplaresPrestados(String titulo){
        for (Libro libro : libros){
            if (libro.getNombre().equals(titulo)){
                return libro.mostrarEjemplaresPrestados();
            }
        }
        return "No se encontro el libro";
    }
}
