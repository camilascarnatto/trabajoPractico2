package punto10;

import java.time.LocalDate;

public class EmpleadoConSalarioBase extends EmpleadoPorComision{
    private float salarioFijo ;
    private float ventasRealizadas;

    private static float EXTRA = 1000;
    public EmpleadoConSalarioBase(String nombre, String telefono, String cuit, LocalDate fecha, float porcentajePorVenta, float salario) {
        super(nombre, telefono, cuit, fecha, porcentajePorVenta);
        this.salarioFijo = salario;
        this.ventasRealizadas = 0;
    }

    public void agregarVentas(float cantidad){
        ventasRealizadas += cantidad;
    }
    public void aumentarSueldo(float monto){
        salarioFijo += monto;
    }

    @Override
    public float calcularBono() {
        return super.calcularBono() + EXTRA;
    }

    @Override
    public float calcularSueldo() {
        return super.calcularSueldo() + salarioFijo;
    }

}
