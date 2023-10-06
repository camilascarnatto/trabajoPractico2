package punto5;

import com.sun.jdi.LongValue;

import java.time.LocalDate;
import java.util.function.LongConsumer;

public class Inversion {
    private  double montoInvertido;
    private LocalDate fechaInicio;
    private boolean activa;

    public Inversion(){
        this.montoInvertido = 0;
        this.activa = false;
        this.fechaInicio = null;
    }

    public double getMontoInvertido() {
        return montoInvertido;
    }


    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void iniciarInversion(double monto){
        if(activa){
            throw new IllegalStateException("Ya tiene una inversion activa");
        }
        if(monto <= 0){
            throw new IllegalArgumentException("Monto invalido");
        }

        montoInvertido  = monto;
        fechaInicio = LocalDate.now();
        activa = true;
    }

    public void cancelarInversion(){
        if(!activa){
            throw new IllegalStateException("No se encontro ninguna inversion activa");
        }
        montoInvertido = 0;
        fechaInicio = null;
        activa = false;
    }

    public double calcularInteresesDevuelto(){
        if(!activa){
            throw new IllegalStateException("No se encontro ninguna inversion activa");
        }

        LocalDate fechaActual = LocalDate.now();
        if(fechaActual.minusDays(30).isAfter(fechaInicio)){
            return montoInvertido * 0.05;
        }else return 0;
    }
}
