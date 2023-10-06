package punto11;

import java.time.LocalDate;
import java.util.ArrayList;

public class EmpresaDeRenta {
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Alquiler> alquileres;

    public EmpresaDeRenta(){
        this.alquileres = new ArrayList<>();
        this.vehiculos = new ArrayList<>();

    }

    public boolean agregarVehiculo(Vehiculo vehiculo){
        if(!vehiculos.contains(vehiculo)){
            vehiculos.add(vehiculo);
            return true;
        }else return false;
    }

    public float montoTotalDeAlquileres(){
        float total = 0;
        for (Alquiler alquiler : alquileres){
            total += alquiler.getPrecioTotal();
        }
        return total;
    }

    public float alquilarVehiculo(Cliente cliente, Presupuesto presupuesto, LocalDate fechaInicio){
        Alquiler alquiler = new Alquiler(cliente, presupuesto, fechaInicio);
        if(presupuesto.getVehiculo().estaDisponible()){
            presupuesto.getVehiculo().alquilar(presupuesto.getCantDias());
            alquileres.add(alquiler);
        }
        return alquiler.getPrecioTotal();
    }

    public Presupuesto pedirPresupuesto(String vehiculoACotizar, int dias){
        for(Vehiculo vehiculo : vehiculos){
            if(vehiculo.getPatente().equals(vehiculoACotizar)){
                return new Presupuesto(vehiculo.calcularPrecio(dias), vehiculo, dias);
            }
        }
        return null;
    }

    public String mostrarAlquileres(){
        String rta = "";
        for (Alquiler alquiler : alquileres){
            rta += alquiler.toString() + "\n";
        }
        return rta;
    }


}
