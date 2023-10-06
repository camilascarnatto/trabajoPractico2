package punto11;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args){

        EmpresaDeRenta empresaDeRenta = new EmpresaDeRenta();
        Auto auto = new Auto("AUTO 0001", 5, false);
        Combi combi = new Combi("COMBI 0001");
        Camion camion = new Camion("CAMION 0001");
        Camioneta camioneta = new Camioneta("CAMIONETA 0001", 300);
        Cliente cliente1 = new Cliente("Camila Scarnatto", "4444444");
        Cliente cliente2 = new Cliente("Maria ", "111111");


        empresaDeRenta.agregarVehiculo(auto);
        empresaDeRenta.agregarVehiculo(combi);
        empresaDeRenta.agregarVehiculo(camioneta);
        empresaDeRenta.agregarVehiculo(camion);


        empresaDeRenta.alquilarVehiculo(cliente1,empresaDeRenta.pedirPresupuesto("AUTO 0001", 5), LocalDate.now());
        empresaDeRenta.alquilarVehiculo(cliente1,empresaDeRenta.pedirPresupuesto("CAMIONETA 0001", 5), LocalDate.now());

        empresaDeRenta.alquilarVehiculo(cliente2,empresaDeRenta.pedirPresupuesto("COMBI 0001", 5), LocalDate.now());
        empresaDeRenta.alquilarVehiculo(cliente2,empresaDeRenta.pedirPresupuesto("CAMION 0001", 5), LocalDate.now());

        System.out.println(empresaDeRenta.mostrarAlquileres());
        System.out.println("MONTO TOTAL DE ALQUILERES: $" + empresaDeRenta.montoTotalDeAlquileres());

        System.out.println(" ");
        System.out.println("CLIENTE: " + cliente1.getNombre() +" -> MONTO EN ALQUILERES $" + cliente1.montoTotalAquileres());
        System.out.println(" ");
        System.out.println("CLIENTE: " + cliente2.getNombre() +" -> MONTO EN ALQUILERES $" + cliente1.montoTotalAquileres());


    }
}
