package punto2;

import java.util.ArrayList;
import java.util.List;

public class Destino {
    private String nombre;
    private double precioBase;
    private List<Excursion> excursiones;

    public Destino(String nombre,  double precioBase) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.excursiones = new ArrayList<>();
    }

    public void agregarExcursion(Excursion excursion) {
        excursiones.add(excursion);
    }

    public double calcularPrecioTotal() {
        // Calcular el precio total del destino incluyendo excursiones y transporte
        return precioBase; // Placeholder, debes implementar la lógica adecuada
    }

    public String getNombre() {
        return nombre;
    }
}
