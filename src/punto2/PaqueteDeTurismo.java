package punto2;

import java.util.List;
import java.util.ArrayList;

public class PaqueteDeTurismo {
    private Cliente cliente;
    private Destino destino;
    private  boolean pagado;
    private Transporte medioDeTransporte;
    private Hospedaje hospedaje;
    private List<Excursion> excursiones;
    private List<Proveedor> proveedores;

    public PaqueteDeTurismo(Cliente cliente, Destino destino, Transporte medioDeTransporte,
                            Hospedaje hospedaje, List<Excursion> excursiones) {
        this.cliente = cliente;
        this.destino = destino;
        this.pagado = false;
        this.medioDeTransporte = medioDeTransporte;
        this.hospedaje = hospedaje;
        this.excursiones = excursiones;
        this.proveedores = new ArrayList<>();
    }

    public void abonarEnEfectivo(double monto) {
        if (!pagado) {
            pagado = true;

        } else {
            throw new IllegalStateException("El paquete ya ha sido pagado en efectivo.");

        }
    }

    public double calcularPrecioTotal() {
        // Calcular el precio total del paquete de turismo considerando todos sus componentes
        double precioTotal = destino.calcularPrecioTotal() +
                medioDeTransporte.calcularPrecioTotal(cliente != null ? cliente.getCompras().size() : 0) +
                hospedaje.calcularPrecioTotal(1) +
                excursiones.stream().mapToDouble(excursion -> excursion.calcularPrecioTotal(1)).sum();
        return precioTotal;
    }

    public void agregarProveedor(Proveedor proveedor) {
        proveedores.add(proveedor);
    }

    public Destino getDestino() {
        return destino;
    }

    public void agregarExcursion(Excursion excursion){
        excursiones.add(excursion);
    }
}
