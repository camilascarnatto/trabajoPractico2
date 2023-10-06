package punto14;

import java.util.ArrayList;

public class Paquete {
    private Destino destino;
    private ArrayList<Proveedor> proveedores;
    private int canMaximaClientes;

    public Paquete(Destino destino, int canMaximaClientes){
        this.destino = destino;
        this.canMaximaClientes = canMaximaClientes;
        proveedores = new ArrayList<>();
    }

    public void agregarProveedor(Proveedor proveedor){
        proveedores.add(proveedor);
    }

    public String getDestino() {
        return destino.getNombre();
    }

    public float calcularPrecio(){
        float precio = 0;
        for (Proveedor proveedor : proveedores){
            precio += proveedor.dineroAPagar(canMaximaClientes);
        }
        return precio;
    }

}
