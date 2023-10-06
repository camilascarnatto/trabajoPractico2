package punto10;

import java.time.LocalDate;

public class EmpleadoPasante extends Empleado {
    public EmpleadoPasante(String nombre, String telefono, String cuit, LocalDate fecha) {
        super(nombre, telefono, cuit, fecha);
    }

    @Override
    public float calcularBono() {
        return 0;
    }
}
