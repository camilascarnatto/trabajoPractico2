package punto1;

import java.time.LocalDate;

public class Socio {
    private String nombre;
    private String mail;
    private String direccion;
    private Suscripcion suscripcion;
    private LocalDate fechaInscripcion;
    private Credencial credencial;
    private Cuota cuota;

    public Socio(String nombre, String direccion, String mail, Suscripcion suscripcion, LocalDate fechaInscripcion){
        this.nombre = nombre;
        this.mail = mail;
        this.direccion = direccion;
        this.suscripcion = suscripcion;
        this.fechaInscripcion = fechaInscripcion;
        this.credencial  =  new Credencial();
    }

    public void pagarCuota(double total){
        cuota.pagar();
    }

    public  boolean  accesoActividad (Actividad actividad){
        return suscripcion.tieneAcceso(actividad);
    }

    public TipoSuscripcion getTipoSuscripcion(){
        return suscripcion.getTipo();
    }

    public double calcularCuotaSuscripcion(){
        return  suscripcion.getPrecio();
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
}
