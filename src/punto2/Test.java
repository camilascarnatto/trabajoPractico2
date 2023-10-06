package punto2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {

        Proveedor proveedor1 = new Proveedor("Aerolíneas Argentinas", "Medio de transporte", "011-9999");
        Proveedor proveedor2 = new Proveedor("Hotel HJ", "Hospedaje", "0800-4478");
        Proveedor proveedor3 = new Proveedor("Excursiones Args", "Excursión", "2323698989");

        Transporte transporte1 = new Transporte("Avión", "Aereo",500.0);
        Transporte transporte2 = new Transporte("Colectivo", "Terrestre",800.0);

        Hospedaje hospedaje1 = new Hospedaje("Hotel HJ Pilar", "Hotel",1000.0);
        Hospedaje hospedaje2 = new Hospedaje("Canañas Helge", "Bungalo",1000.0);


        Destino destino1 = new Destino("Playa del Carmen", 6000.0);
        Destino destino2 = new Destino("Bariloche", 4000.0);

        Cliente cliente1 = new Cliente("Maria Rosa", "001", "011234234");
        Cliente cliente2 = new Cliente("Pedro", "002", "011234234");
        Cliente cliente3 = new Cliente("Juan", "003", "011234234");
        Cliente cliente4 = new Cliente("Lucas", "004", "011234234");

        List<Excursion> excursiones1 = new ArrayList<>();
        excursiones1.add(new Excursion("Tour", "salida 8am", 50.0));
        excursiones1.add(new Excursion("Paseo montañas", "salida 11am", 30.0));

        List<Excursion> excursiones2 = new ArrayList<>();
        excursiones2.add(new Excursion("Tour en ciudad","Salida 15pm", 2000.0));
        excursiones2.add( new Excursion("Cabalgata","Salida 18pm", 5000.0));

        PaqueteDeTurismo paquete1 = new PaqueteDeTurismo(cliente1, destino1,transporte1, hospedaje1, excursiones1);
        PaqueteDeTurismo paquete2 = new PaqueteDeTurismo(cliente2, destino2,transporte2, hospedaje2, excursiones2);


        cliente1.realizarCompra(paquete1);
        cliente2.realizarCompra(paquete2);
        cliente3.realizarCompra(paquete2);
        cliente4.realizarCompra(paquete2);

        List<PaqueteDeTurismo> ventasRealizadas = new ArrayList<>();
        ventasRealizadas.add(paquete1);
        ventasRealizadas.add(paquete2);
        ventasRealizadas.add(paquete2);
        ventasRealizadas.add(paquete2);

        //Informe que contenga un listado de todas las ventas realizadas, organizadas por destino.
        Map<String,Double> ventasPorDestino = new HashMap<>();
        for (PaqueteDeTurismo venta : ventasRealizadas){
            String destino = venta.getDestino().getNombre();
            double precio = venta.getDestino().calcularPrecioTotal();
            ventasPorDestino.put(destino, ventasPorDestino.getOrDefault(destino, 0.0) + precio);
        }
        System.out.println("- INFORME DE VENTAS ORGANIZADAS POR DESTINO - \n");
        for (String destino : ventasPorDestino.keySet()){
            double totalVentas = ventasPorDestino.get(destino);
            System.out.println("Destino: " + destino + ", con un total de ventas: $" + totalVentas);
        }

        //También quiere conocer cuál es el destino favorito por sus clientes.
        String destinoFavorito = encontrarDestinoFavorito (ventasPorDestino);
        System.out.println("\nEl destino favorito de los clientes es: " + destinoFavorito);

    }

    private static String encontrarDestinoFavorito(Map<String,Double> ventasPorDestino){
        String destinoFav = null;
        double maxVentas =  0.0;

        for(Map.Entry<String, Double> entry : ventasPorDestino.entrySet()){
            if(entry.getValue() > maxVentas){
                destinoFav = entry.getKey();
                maxVentas = entry.getValue();
            }
        }
        return destinoFav;
    }
}
