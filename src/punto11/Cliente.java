package punto11;

import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String dni;
    private ArrayList<Alquiler> alquileres;

    public Cliente(String nombre,  String dni){
        this.nombre = nombre;
        this.dni  = dni;
        this.alquileres = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public float montoTotalAquileres(){
        float monto = 0;
        for (Alquiler alquiler : alquileres){
            monto += alquiler.getPrecioTotal();
        }
        return  monto;
    }

    public void agregarAlquiler(Alquiler alquiler){
        alquileres.add(alquiler);
    }
}
