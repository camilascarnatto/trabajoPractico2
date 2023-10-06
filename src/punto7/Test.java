package punto7;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        // Crear una instancia de la estación de servicio
        EstacionDeServicio estacion = new EstacionDeServicio();

        // Crear algunos objetos Combustible
        Combustible nafta = new Combustible("Nafta", 1.5);
        Combustible gasoil = new Combustible("Gasoil", 1.2);

        // Agregar los combustibles a la estación
        estacion.agregarCombustible(nafta);
        estacion.agregarCombustible(gasoil);

        // Crear algunos expendedores
        Expendedor exp1 = new Expendedor(nafta);
        Expendedor exp2 = new Expendedor(gasoil);

        // Agregar expendedores a la estación
        estacion.agregarExpendedor(exp1);
        estacion.agregarExpendedor(exp2);


        Playero playero1 = new Playero("Juan");
        Playero playero2 = new Playero("María");


        estacion.agregarPlayero(playero1);
        estacion.agregarPlayero(playero2);

        // Crear 10 clientes
        for (int i = 1; i <= 10; i++) {
            String patente = generarPatenteAleatoria();
            Cliente cliente = new Cliente(patente);
            estacion.agregarCliente(cliente);
        }

        // Obtener la fecha actual y la fecha hace 24 horas
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaAnterior = LocalDate.now().minusDays(1);

        // Realizar ventas aleatorias con fechas
        Random random = new Random();
        List<Cliente> clientes = estacion.getClientes();
        List<Expendedor> expendedores = estacion.getExpendedores();
        List<Playero> playeros = estacion.getPlayeros();

        for (int i = 0; i < 50; i++) {
            Cliente cliente = clientes.get(random.nextInt(clientes.size()));
            Expendedor expendedor = expendedores.get(random.nextInt(expendedores.size()));
            Playero playero = playeros.get(random.nextInt(playeros.size()));
            double totalVenta = 20.0 + random.nextDouble() * 80.0;
            double litros = 10.0 + random.nextDouble() * 40.0;

            LocalDate fechaVenta = random.nextBoolean() ? fechaActual : fechaAnterior;
            estacion.realizarVenta(cliente, expendedor, totalVenta, litros, playero, fechaVenta);
        }

        // Descuentos si estan en el top10Clientes / Top10Playeros
        testDescuentoClienteTop10(estacion);
        testDescuentoPlayeroTop10(estacion);

        // Obtener informes
        Map<String, Double> proporcionesVentas = estacion.obtenerProporcionVentasPorTipoCombustible();
        List<Expendedor> surtidoresMontoVentas = estacion.obtenerSurtidoresOrdenadosPorMontoTotalVentas();
        List<Expendedor> surtidoresLitrosExpendidos = estacion.obtenerSurtidoresOrdenadosPorCantidadLitrosExpendidos();
        List<Playero> empleadosMontoVentas = estacion.obtenerEmpleadosOrdenadosPorMontoTotalVentas();
        List<Cliente> top10Clientes = estacion.obtenerTop10ClientesPorMontoTotalCompras();

        // Imprimir informes
        System.out.println("\nProporción de ventas efectuadas por tipo de combustible:");
        for (Map.Entry<String, Double> entry : proporcionesVentas.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\nSurtidores ordenados por monto total de ventas:");
        for (Expendedor expendedor : surtidoresMontoVentas) {
            String monto = decimalFormat.format(estacion.calcularMontoTotalVentasPorSurtidor(expendedor));
            System.out.println("Surtidor: " + expendedor.getTipoCombustible().getTipo() + ", Monto Total de Ventas: " + monto);
        }

        System.out.println("\nSurtidores ordenados por cantidad de litros expendidos:");
        for (Expendedor expendedor : surtidoresLitrosExpendidos) {
            String total = decimalFormat.format(estacion.calcularCantidadLitrosExpendidosPorSurtidor(expendedor));
            System.out.println("Surtidor: " + expendedor.getTipoCombustible().getTipo() + ", Litros Expendidos: " + total);
        }

        System.out.println("\nEmpleados ordenados por monto total de ventas:");
        for (Playero playero : empleadosMontoVentas) {
            String total = decimalFormat.format(estacion.calcularMontoTotalVentasPorEmpleado(playero));
            System.out.println("Empleado: " + playero.getNombre() + ", Monto Total de Ventas: " + total);
        }

        System.out.println("\nTop 10 de clientes según monto total de compras:");
        for (Cliente cliente : top10Clientes) {
            String montoFormateado = decimalFormat.format(cliente.getTotalCompras());
            System.out.println("Cliente: " + cliente.getPatente() + ", Monto Total de Compras: " + montoFormateado);
        }
    }

    // Método para generar una patente aleatoria (solo para fines de prueba)
    private static String generarPatenteAleatoria() {
        Random random = new Random();
        StringBuilder patente = new StringBuilder();

        // Generar las dos letras iniciales
        for (int i = 0; i < 2; i++) {
            char letra = (char) (random.nextInt(26) + 'A');
            patente.append(letra);
        }

        // Generar los tres números
        for (int i = 0; i < 3; i++) {
            int numero = random.nextInt(10);
            patente.append(numero);
        }

        // Generar las dos letras finales
        for (int i = 0; i < 2; i++) {
            char letra = (char) (random.nextInt(26) + 'A');
            patente.append(letra);
        }

        return patente.toString();
    }

    private static void testDescuentoClienteTop10(EstacionDeServicio estacion) {
        System.out.println("\nPrueba de descuento del 5% para clientes del Top 10 del mes anterior:");

        // Obtener clientes del Top 10
        List<Cliente> top10Clientes = estacion.obtenerTop10ClientesPorMontoTotalCompras();
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        for (Cliente cliente : top10Clientes) {

            String monto = decimalFormat.format(cliente.getTotalCompras());
            System.out.println("Cliente: " + cliente.getPatente() + ", Monto Total de Compras (sin descuento): " + monto);

            // Realizar venta para este cliente y verificar si se aplica el descuento
            double totalVenta = 100.0; // Puedes ajustar el monto de la venta según tu escenario
            double litros = 50.0; // Puedes ajustar la cantidad de litros vendidos según tu escenario

            estacion.realizarVenta(cliente, estacion.getExpendedores().get(0), totalVenta, litros, estacion.getPlayeros().get(0), LocalDate.now());

            // Imprimir el nuevo total de compras del cliente después de la venta
            String total = decimalFormat.format(cliente.getTotalCompras());
            System.out.println("Cliente: " + cliente.getPatente() + ", Monto Total de Compras (con descuento): " + total);
        }
    }

    private static void testDescuentoPlayeroTop10(EstacionDeServicio estacion) {
        System.out.println("\nPrueba de descuento del 10% para empleados del Top 10 del mes anterior:");

        // Obtener empleados del Top 10
        List<Playero> top10Playeros = estacion.obtenerEmpleadosOrdenadosPorMontoTotalVentas();
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        for (Playero playero : top10Playeros) {

            String monto = decimalFormat.format(estacion.calcularMontoTotalVentasPorEmpleado(playero));
            System.out.println("Playero: " + playero.getNombre() + ", Monto Total de Ventas (sin descuento): " + monto);

            // Realizar venta con descuento para este empleado y verificar si se aplica el descuento al cliente
            double totalVenta = 100.0; // Puedes ajustar el monto de la venta según tu escenario
            double litros = 50.0; // Puedes ajustar la cantidad de litros vendidos según tu escenario

            Cliente cliente = estacion.getClientes().get(0); // Puedes ajustar para seleccionar un cliente específico

            estacion.realizarVenta(cliente, estacion.getExpendedores().get(0), totalVenta, litros, playero, LocalDate.now());

            // Imprimir el nuevo total de compras del cliente después de la venta
            String total = decimalFormat.format(cliente.getTotalCompras());

            System.out.println("Cliente: " + cliente.getPatente() + ", Monto Total de Compras (con descuento): " + total);
        }
    }

}
