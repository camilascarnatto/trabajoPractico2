package punto2;

public class Transporte {
    private String nombre;
    private String tipo;
    private double precioPorPersona;

    public Transporte(String nombre, String tipo, double precioPorPersona) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precioPorPersona = precioPorPersona;
    }

    public double calcularPrecioTotal(int personas) {
        // Calcular el precio total del transporte para un número específico de personas
        return precioPorPersona * personas;
    }

}
