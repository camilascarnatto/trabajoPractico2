package punto10;

import java.time.LocalDate;

public class Empleado {
    private String nombre;
    private String telefono;
    private String cuit;
    private LocalDate fechaNacimiento;
    private static float BONO = 2000;

    public Empleado(String nombre, String telefono, String cuit, LocalDate fecha){
        this.nombre = nombre;
        this.cuit  =cuit;
        this.telefono = telefono;
        this.fechaNacimiento = fecha;
    }

    public float calcularSueldo(){
        return 0;
    }

    public float darBonoCumpleanos(){
        if (fechaNacimiento.getMonthValue() == LocalDate.now().getMonthValue()){
            return calcularBono();
        }
        return 0;
    }

    public float calcularBono() {
        return BONO;
    }

    public float getBaseBonoCumpleanos() {
        return BONO;
    }
}
