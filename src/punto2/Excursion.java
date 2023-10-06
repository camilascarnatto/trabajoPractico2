package punto2;

public class Excursion {
    private String nombre;
    private String descripcion;
    private double precioPorPersona;

    public Excursion(String nombre, String descripcion, double precioPorPersona) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioPorPersona = precioPorPersona;
    }

    public double calcularPrecioTotal(int personas) {
        // Calcular el precio total de la excursión para un número específico de personas
        return precioPorPersona * personas;
    }

}
