package punto10;

import java.time.LocalDate;

public class EmpleadoAsalariado extends  Empleado{
    private float sumaFijaMensual;
    private static float EXTRA = 1000;
    public EmpleadoAsalariado(String nombre, String telefono, String cuit, LocalDate fecha, float sumaFija) {
        super(nombre, telefono, cuit, fecha);
        this.sumaFijaMensual = sumaFija;
    }

    protected void aumentarSueldo(float monto){
        sumaFijaMensual += monto;
    }

    protected  void aumentarExtra(float monto){
        EXTRA += monto;
    }

    public static float getExtra(){
        return  EXTRA;
    }

    public float getSumaFijaMensual(){
        return sumaFijaMensual;
    }

    @Override
    public float calcularSueldo() {
        return sumaFijaMensual;
    }

    @Override
    public float calcularBono() {
        return EXTRA + super.getBaseBonoCumpleanos();
    }
}
