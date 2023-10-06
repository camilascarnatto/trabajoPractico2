package punto11;

import java.time.LocalDate;

public class Alquiler {
    private Cliente cliente;
    private Presupuesto presupuesto;
    private LocalDate desde;
    private LocalDate hasta;
    private float precioTotal;

    public Alquiler(Cliente cliente, Presupuesto presupuesto, LocalDate fechaIni){
        this.cliente = cliente;
        this.presupuesto = presupuesto;
        this.desde = fechaIni;
        this.hasta = desde.plusDays(presupuesto.getCantDias());
        cliente.agregarAlquiler(this);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public String toString(){
        return "Alquiler de " + presupuesto.getVehiculo().getPatente() +
                ":\nCliente: " + cliente.getNombre() +
                "\nCon fecha de inicio: " + desde + " y fecha fin: " + hasta +
                "\n Total $" + getPrecioTotal();

    }
}
