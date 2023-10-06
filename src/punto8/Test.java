package punto8;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        // Crear la biblioteca
        Biblioteca biblioteca = new Biblioteca();

        // Crear algunos socios
        Socio socio1 = new Socio("Camila Scarnatto", "1234", "55158");
        Socio socio2 = new Socio("Martina Perez", "9999", "666");

        // Crear algunos autores
        Autor autor1 = new Autor("Hernan", "Casciari");
        Autor autor2 = new Autor("Gabriel", "Rolon");

        // Agregar publicaciones a la biblioteca
        biblioteca.agregarPublicacion("Historias de divan", "Planeta", "08003333",
                autor1, 370, "0001", 5);

        biblioteca.agregarPublicacion("Messi es un perro", "Orzai", "0113423",
                autor2, 410, "0002", 7);

        // Prestar algunos libros
        biblioteca.prestarLibroPorISBN("0001", 3, socio1, 2);
        biblioteca.prestarLibroPorISBN("0002", 2, socio2, 3);
        biblioteca.prestarLibroPorISBN("0001", 1, socio2, 4);

        // Mostrar ejemplares prestados
        System.out.println("Ejemplares prestados de Historias de Divan: \n" +
                biblioteca.ejemplaresPrestados("Historias de divan"));

        // Contabilizar cantidad de ejemplares disponibles
        System.out.println("Cantidad de ejemplares disponibles de Historias de Divan: \n" +
                biblioteca.cantidadEjemplaresDisponibles("Historias de divan"));

        // Mostrar préstamos por socio
        mostrarPrestamos(socio1);
        mostrarPrestamos(socio2);
    }

    // Método para mostrar préstamos de un socio
    private static void mostrarPrestamos(Socio socio) {
        System.out.println("Préstamos de " + socio.getNombre() + ":");
        ArrayList<Prestamo> prestamos = socio.getPrestamos();
        for (Prestamo prestamo : prestamos) {
            System.out.println("Libro: " + prestamo.getLibro().getNombre() +
                    ", Nro de Ejemplar: " + prestamo.getNroEjemplar() +
                    ", Fecha de devolución: " + prestamo.getFechaHasta());
        }
        System.out.println("------------------------");
    }
}
