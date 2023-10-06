package punto8;

import java.time.LocalDate;

public class Prestamo {
    private Socio socio;
    private Libro libro;
    private int nroEjemplar;
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;

    public Prestamo(Socio socio, Libro libro, int nroEjemplar, int cantidadDias){
        this.socio = socio;
        this.libro = libro;
        this.nroEjemplar = nroEjemplar;
        this.fechaDesde = LocalDate.now();
        this.fechaHasta = fechaDesde.plusDays(cantidadDias);
    }

    public int getNroEjemplar() {
        return nroEjemplar;
    }

    public LocalDate getFechaHasta() {
        return fechaHasta;
    }

    public Libro getLibro() {
        return libro;
    }

    public Socio getSocio() {
        return socio;
    }
}
