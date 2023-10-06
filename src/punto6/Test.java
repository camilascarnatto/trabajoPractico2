package punto6;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
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

        // Crear algunos empleados
        Playero playero1 = new Playero("Juan");
        Playero playero2 = new Playero("María");

        // Agregar empleados a la estación
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

        // Obtener informes
        Map<String, Double> proporcionesVentas = estacion.obtenerProporcionVentasPorTipoCombustible();
        List<Expendedor> surtidoresMontoVentas = estacion.obtenerSurtidoresOrdenadosPorMontoTotalVentas();
        List<Expendedor> surtidoresLitrosExpendidos = estacion.obtenerSurtidoresOrdenadosPorCantidadLitrosExpendidos();
        List<Playero> empleadosMontoVentas = estacion.obtenerEmpleadosOrdenadosPorMontoTotalVentas();
        List<Cliente> top10Clientes = estacion.obtenerTop10ClientesPorMontoTotalCompras();

        // Imprimir informes
        System.out.println("Proporción de ventas efectuadas por tipo de combustible:");
        for (Map.Entry<String, Double> entry : proporcionesVentas.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\nSurtidores ordenados por monto total de ventas:");
        for (Expendedor expendedor : surtidoresMontoVentas) {
            System.out.println("Surtidor: " + expendedor.getTipoCombustible().getTipo() + ", Monto Total de Ventas: " + estacion.calcularMontoTotalVentasPorSurtidor(expendedor));
        }

        System.out.println("\nSurtidores ordenados por cantidad de litros expendidos:");
        for (Expendedor expendedor : surtidoresLitrosExpendidos) {
            System.out.println("Surtidor: " + expendedor.getTipoCombustible().getTipo() + ", Litros Expendidos: " + estacion.calcularCantidadLitrosExpendidosPorSurtidor(expendedor));
        }

        System.out.println("\nEmpleados ordenados por monto total de ventas:");
        for (Playero playero : empleadosMontoVentas) {
            System.out.println("Empleado: " + playero.getNombre() + ", Monto Total de Ventas: " + estacion.calcularMontoTotalVentasPorEmpleado(playero));
        }

        System.out.println("\nTop 10 de clientes según monto total de compras:");
        DecimalFormat decimalFormat = new DecimalFormat("#.##"); // Define el formato con dos dígitos decimales
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
}
