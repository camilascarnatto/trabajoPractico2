package punto2;

public class Hospedaje {
    private String nombre;
    private String tipo;
    private double precioPorNoche;

    public Hospedaje(String nombre, String tipo, double precioPorNoche) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precioPorNoche = precioPorNoche;
    }

    public double calcularPrecioTotal(int noches) {
        // Calcular el precio total del hospedaje para un número específico de noches
        return precioPorNoche * noches;
    }

}
