package punto2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Agencia {

    private List<Cliente> clientes;
    private List<Proveedor> proveedores;
    private List<PaqueteDeTurismo> paquetesDeTurismo;
    private Map<String, List<PaqueteDeTurismo>> registroComprasPorCliente;
    private Map<Destino, List<PaqueteDeTurismo>> ventasPorDestino;


    public Agencia() {
        clientes = new ArrayList<>();
        proveedores = new ArrayList<>();
        paquetesDeTurismo = new ArrayList<>();
        registroComprasPorCliente = new HashMap<>();
        ventasPorDestino = new HashMap<>();
    }

    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
        registroComprasPorCliente.put(cliente.getIdentificacion(), new ArrayList<>());
    }

    public void registrarProveedor(Proveedor proveedor) {
        proveedores.add(proveedor);
    }

    public void crearPaqueteDeTurismo(Destino destino, Transporte transporte,
                                      Hospedaje hospedaje, List<Excursion> excursiones) {
        PaqueteDeTurismo paquete = new PaqueteDeTurismo(null, destino, transporte, hospedaje, excursiones);
        paquetesDeTurismo.add(paquete);
    }

    public void crearPaqueteDeTurismo(PaqueteDeTurismo paqueteDeTurismo) {
        paquetesDeTurismo.add(paqueteDeTurismo);
    }

    public void realizarVenta(PaqueteDeTurismo paqueteDeTurismo, Cliente cliente) {
        paqueteDeTurismo.abonarEnEfectivo(paqueteDeTurismo.calcularPrecioTotal());
        cliente.realizarCompra(paqueteDeTurismo);
        registroComprasPorCliente.get(cliente.getIdentificacion()).add(paqueteDeTurismo);
        registrarVentaPorDestino(paqueteDeTurismo);

    }

    private void registrarVentaPorDestino(PaqueteDeTurismo paqueteDeTurismo) {
        Destino destino = paqueteDeTurismo.getDestino();
        if (!ventasPorDestino.containsKey(destino)) {
            ventasPorDestino.put(destino, new ArrayList<>());
        }
        ventasPorDestino.get(destino).add(paqueteDeTurismo);
    }

    public Map<Destino, List<PaqueteDeTurismo>> generarInformeVentasPorDestino() {
        return ventasPorDestino;
    }

    public Destino obtenerDestinoFavorito() {
        Destino destinoFavorito = null;
        int maxVentas = 0;

        for (Map.Entry<Destino, List<PaqueteDeTurismo>> entry : ventasPorDestino.entrySet()) {
            int ventas = entry.getValue().size();
            if (ventas > maxVentas) {
                maxVentas = ventas;
                destinoFavorito = entry.getKey();
            }
        }

        return destinoFavorito;
    }

}
