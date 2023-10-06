package punto10;

import java.time.LocalDate;

public class EmpleadoPorComision extends Empleado{
    private float porcentajePorVenta;
    private int cantidadVentas;
    private static float PORCENTAJE;
    public EmpleadoPorComision(String nombre, String telefono, String cuit, LocalDate fecha, float porcentaje) {
        super(nombre, telefono, cuit, fecha);
        this.porcentajePorVenta = porcentaje;
        this.cantidadVentas = 0;
    }

    public void agregarVentas(int monto){
        cantidadVentas += monto;
    }
    public void reiniciarVentas(){
        cantidadVentas = 0;
    }
    @Override
    public float calcularSueldo(){
        return cantidadVentas * porcentajePorVenta / 100;
    }

    @Override
    public float calcularBono() {
        return (float) (super.calcularBono() + (cantidadVentas * 0.005));
    }

}
