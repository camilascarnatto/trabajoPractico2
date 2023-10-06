package punto10;

import java.time.LocalDate;

public class EmpleadoPorHora extends  Empleado{
    private float horasTrabajadas;
    private float montoPorHora;
    public EmpleadoPorHora(String nombre, String telefono, String cuit, LocalDate fecha, float montoPorHora, float horas) {
        super(nombre, telefono, cuit, fecha);
        this.montoPorHora = montoPorHora;
        this.horasTrabajadas = horas;
    }

    public void agregarHorasTrabajadas(float horas){
        horasTrabajadas += horas;
    }

    public void aumentarMontoPorHora(float aumento){
        montoPorHora += aumento;
    }

    @Override
    public float calcularSueldo() {
        float sueldo = horasTrabajadas * montoPorHora;
        if(horasTrabajadas > 40){
            sueldo += sueldo * 0.2;
        }
        return sueldo;
    }

}
