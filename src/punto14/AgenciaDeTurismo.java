package punto14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class AgenciaDeTurismo {
    private ArrayList<Cliente> clientes;
    private ArrayList<Paquete> paquetes;
    private ArrayList <Proveedor> proveedores;
    private ArrayList <Venta> ventas;
    private Map<String, Integer> ventasPorDestino;

    public AgenciaDeTurismo(){
        clientes = new ArrayList<Cliente>();
        paquetes = new ArrayList<Paquete>();
        proveedores = new ArrayList<Proveedor>();
        ventas = new ArrayList<Venta>();
        ventasPorDestino = new HashMap<>();
    }

    public void agregarCliente(String nombre, String apellido, String mail,String dni){
        for (Cliente cliente : clientes){
            if (cliente.getDni().equals(dni)){
                return;
            }
        }
        Cliente cliente = new Cliente(nombre,apellido,mail,dni);
        clientes.add(cliente);
    }

    public void agregarProveedor(Proveedor proveedor){
        for (Proveedor proveedor1 : proveedores){
            if (proveedor1.getCuit().equals(proveedor.getCuit())){
                return;
            }
        }
        proveedores.add(proveedor);
    }

    public void agregarPaquete(Paquete paquete){
        for (Paquete paquete1 : paquetes){
            if (paquete1.equals(paquete1)){
                return;
            }
        }
        paquetes.add(paquete);
    }

    public void realizarVenta(String dni, Paquete paquete){
        for (Cliente cliente : clientes){
            if (cliente.getDni().equals(dni)){
                Venta venta = new Venta(cliente,paquete);
                ventas.add(venta);
                agregarDestino(paquete.getDestino());
            }
        }
    }

    private void agregarDestino(String nombre){
        if (ventasPorDestino.containsKey(nombre)) {
            int cantidad = ventasPorDestino.get(nombre);
            cantidad++;
            ventasPorDestino.put(nombre,cantidad);
        } else {
            ventasPorDestino.put(nombre,0);
        }
    }
    public String obtenerDestinoFavorito(){
        String favorito = "";
        int mayor = 0;
        for (HashMap.Entry<String, Integer> entrada : ventasPorDestino.entrySet()) {
            if (entrada.getValue() > mayor){
                mayor = entrada.getValue();
                favorito = entrada.getKey();
            }
        }
        return favorito;
    }

    public String obtenerVentasPorDestino(){
        StringBuilder res = new StringBuilder("\t\tVENTAS POR DESTINO\n\n");
        for (String clave : ventasPorDestino.keySet()) {
            res.append(clave.toUpperCase(Locale.ROOT)).append(": \n");
            for (Venta venta : ventas){
                if (venta.obtenerDestino().equals(clave)){
                    res.append(venta.getCliente()).append("(").append(venta.getFecha()).append("): $").append(venta.getPrecio()).append("\n");
                }
            }
        }
        return res.toString();
    }

    public String obtenerProveedores(){
        String res = "\n\t\tPROVEEDORES\n\n";
        for (Proveedor proveedor : proveedores){
            res += "Razon social: " + proveedor.getRazonSocial() + "\nCUIT: " + proveedor.getCuit() +
                    "\nTelefono: " + proveedor.getTelefono() + "\nTipo: " + proveedor.getTipo() +
                    "\n\n";
        }
        return res;
    }

}
