package punto14;

import java.time.LocalDate;

public class Venta {
    private Cliente cliente;
    private Paquete paquete;
    private LocalDate fecha;
    private float precio;

    public Venta(Cliente cliente, Paquete paquete){
        this.cliente = cliente;
        this.paquete = paquete;
        fecha = LocalDate.now();
        precio = paquete.calcularPrecio();
    }
    public String obtenerDestino(){
        return paquete.getDestino();
    }

    public float getPrecio() {
        return precio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getCliente() {
        return cliente.getNombre() + " " + cliente.getApellido();
    }

}
