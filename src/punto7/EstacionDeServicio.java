package punto7;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class EstacionDeServicio {
    private List<Expendedor> expendedores;
    private List<Combustible> combustibles;

    private List<Playero> playeros;
    private List<Cliente> clientes;
    private List<Venta> ventas;
    private List<Cliente> top10ClientesMesAnterior;
    private List<Playero> top10PlayerosMesAnterior;

    public EstacionDeServicio(){
        this.expendedores = new ArrayList<>();
        this.playeros = new ArrayList<>();
        this.ventas = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.combustibles = new ArrayList<>();
        this.top10ClientesMesAnterior = new ArrayList<>();
        this.top10PlayerosMesAnterior = new ArrayList<>();
    }


    public void agregarExpendedor(Expendedor expendedor) {
        expendedores.add(expendedor);
    }

    public void agregarCombustible(Combustible combustible) {
        combustibles.add(combustible);
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void agregarPlayero(Playero playero) {
        playeros.add(playero);
    }

    public List<Playero> getPlayeros() {
        return playeros;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Expendedor> getExpendedores() {
        return expendedores;
    }

    public void realizarVenta(Cliente cliente, Expendedor expendedor, double totalVenta, double litros, Playero playero, LocalDate fecha){
        //Verifica si el cliente estaba en el top 10 del mes anterior
        boolean clienteEstaEnElTop10 = top10ClientesMesAnterior.stream()
                .anyMatch(topCliente -> topCliente.getPatente().equals(cliente.getPatente()));

        //Aplica descuento si el cliente está en el top
        if(clienteEstaEnElTop10){
            totalVenta *= 0.95;
        }

        //Verifica si el empleado está en el top 10
        if(top10PlayerosMesAnterior.contains(playero)){
            if(!playero.isAplicoDescuento()){
                playero.aplicarDescuento();
                //Aplica el descuento
                double descuento = 0.10;
                totalVenta *= (1 - descuento);
            }
        }

        Venta venta = new Venta(cliente, expendedor.getTipoCombustible(), totalVenta, litros, playero, fecha);
        ventas.add(venta);
        cliente.actualizarTotalCompras(totalVenta);
        actualizarTop10ClientesMesAnterior();
        actualizarTop10PlayerosMesAnterior();
    }

    private void actualizarTop10PlayerosMesAnterior() {
        // Obtener la fecha del mes anterior
        LocalDate fechaMesAnterior = LocalDate.now().minusMonths(1);

        // Filtrar las ventas del mes anterior
        List<Venta> ventasMesAnterior = ventas.stream()
                .filter(venta -> venta.getFecha().getMonth() == fechaMesAnterior.getMonth())
                .collect(Collectors.toList());

        // Contar las ventas por empleado y ordenar por monto total de ventas
        Map<Playero, Double> totalVentasPorEmpleado = new HashMap<>();
        for (Venta venta : ventasMesAnterior) {
            Playero playero = venta.getPlayero();
            double totalVentas = totalVentasPorEmpleado.getOrDefault(playero, 0.0) + venta.getTotalVenta();
            totalVentasPorEmpleado.put(playero, totalVentas);
        }

        top10PlayerosMesAnterior = totalVentasPorEmpleado.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }


    private void actualizarTop10ClientesMesAnterior() {
        // Obtener la fecha del mes anterior
        LocalDate fechaMesAnterior = LocalDate.now().minusMonths(1);

        // Filtrar las ventas del mes anterior
        List<Venta> ventasMesAnterior = ventas.stream()
                .filter(venta -> venta.getFecha().getMonth() == fechaMesAnterior.getMonth())
                .collect(Collectors.toList());

        // Contar las ventas por cliente y ordenar por monto total de compras
        Map<Cliente, Double> totalComprasPorCliente = new HashMap<>();
        for (Venta venta : ventasMesAnterior) {
            Cliente cliente = venta.getCliente();
            double totalCompras = totalComprasPorCliente.getOrDefault(cliente, 0.0) + venta.getTotalVenta();
            totalComprasPorCliente.put(cliente, totalCompras);
        }

        top10ClientesMesAnterior = totalComprasPorCliente.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }



    // Listado de la proporcion de ventas efectuadas para cada tipo de combustible
    public Map<String, Double> obtenerProporcionVentasPorTipoCombustible() {
        Map<String, Double> proporciones = new HashMap<>();
        int totalVentas = ventas.size();

        for (Venta venta : ventas) {
            Combustible tipoCombustible = venta.getTipoCombustible();
            proporciones.put(tipoCombustible.getTipo(), proporciones.getOrDefault(tipoCombustible.getTipo(), 0.0) + 1);
        }

        for (Map.Entry<String, Double> entry : proporciones.entrySet()) {
            entry.setValue(entry.getValue() / totalVentas);
        }

        return proporciones;
    }

    // Listado de surtidores ordenados por monto total de ventas
    public List<Expendedor> obtenerSurtidoresOrdenadosPorMontoTotalVentas() {
        List<Expendedor> surtidores = new ArrayList<>(expendedores);
        surtidores.sort(Comparator.comparingDouble(this::calcularMontoTotalVentasPorSurtidor).reversed());
        return surtidores;
    }

    public double calcularMontoTotalVentasPorSurtidor(Expendedor expendedor) {
        return ventas.stream()
                .filter(venta -> venta.getTipoCombustible().equals(expendedor.getTipoCombustible()))
                .mapToDouble(Venta::getTotalVenta)
                .sum();
    }



    // Listado de surtidores ordenados por monto total de ventas
    public List<Playero> obtenerEmpleadosOrdenadosPorMontoTotalVentas() {
        Map<Playero, Double> ventasPorEmpleado = new HashMap<>();

        for (Venta venta : ventas) {
            Playero playero = venta.getPlayero();
            double totalVentasEmpleado = ventasPorEmpleado.getOrDefault(playero, 0.0);
            totalVentasEmpleado += venta.getTotalVenta();
            ventasPorEmpleado.put(playero, totalVentasEmpleado);
        }

        List<Playero> empleados = new ArrayList<>(ventasPorEmpleado.keySet());
        empleados.sort(Comparator.comparingDouble(ventasPorEmpleado::get).reversed());
        return empleados;
    }

    public double calcularMontoTotalVentasPorEmpleado(Playero playero) {
        return ventas.stream()
                .filter(venta -> venta.getPlayero().equals(playero))
                .mapToDouble(Venta::getTotalVenta)
                .sum();
    }

    // Top 10 de clientes segun el monto total de compras
    public List<Cliente> obtenerTop10ClientesPorMontoTotalCompras() {
        LocalDate fechaActual = LocalDate.now(); // Obtener la fecha actual

        // Calcular el monto total de compras por cliente y actualizarlo
        clientes.forEach(cliente -> cliente.actualizarTotalCompras(calcularMontoTotalCompras(cliente, fechaActual)));

        // Ordenar la lista de clientes por monto total de compras
        List<Cliente> topClientes = clientes.stream()
                .sorted(Comparator.comparingDouble(Cliente::getTotalCompras).reversed())
                .limit(10)
                .collect(Collectors.toList());

        return topClientes;
    }

    private double calcularMontoTotalCompras(Cliente cliente, LocalDate fecha) {
        return ventas.stream()
                .filter(venta -> venta.getCliente().equals(cliente) && venta.getFecha().equals(fecha)) // Filtrar por fecha
                .mapToDouble(Venta::getTotalVenta)
                .sum();
    }

    // Listado de surtidores ordenadados por litros expedidos

    public List<Expendedor> obtenerSurtidoresOrdenadosPorCantidadLitrosExpendidos() {
        Map<Combustible, Double> litrosExpendidosPorCombustible = new HashMap<>();

        // Inicializar el mapa con 0 litros para cada tipo de combustible
        for (Combustible combustible : combustibles) {
            litrosExpendidosPorCombustible.put(combustible, 0.0);
        }

        // Calcular la cantidad total de litros vendidos por cada tipo de combustible
        for (Venta venta : ventas) {
            Combustible combustible = venta.getTipoCombustible();
            double litrosExpendidos = litrosExpendidosPorCombustible.get(combustible) + venta.getLitrosExpendidos();
            litrosExpendidosPorCombustible.put(combustible, litrosExpendidos);
        }

        // Ordenar los tipos de combustible por la cantidad total de litros expendidos
        List<Combustible> tiposCombustibleOrdenados = combustibles.stream()
                .sorted(Comparator.comparingDouble(litrosExpendidosPorCombustible::get).reversed())
                .collect(Collectors.toList());

        // Obtener los expendedores correspondientes a los tipos de combustible ordenados
        List<Expendedor> surtidoresOrdenados = tiposCombustibleOrdenados.stream()
                .map(this::obtenerExpendedorPorTipo)
                .collect(Collectors.toList());

        return surtidoresOrdenados;
    }

    // Método para obtener un expendedor por tipo de combustible
    private Expendedor obtenerExpendedorPorTipo(Combustible combustible) {
        return expendedores.stream()
                .filter(expendedor -> expendedor.getTipoCombustible().equals(combustible))
                .findFirst()
                .orElse(null); // Manejar el caso en el que no se encuentre un expendedor para el tipo de combustible
    }

    public double calcularCantidadLitrosExpendidosPorSurtidor(Expendedor expendedor) {
        return ventas.stream()
                .filter(venta -> venta.getTipoCombustible().equals(expendedor.getTipoCombustible()))
                .mapToDouble(Venta::getLitrosExpendidos)
                .sum();
    }

    // Método para que un empleado aplique un descuento del 10% a un cliente específico
    public void aplicarDescuentoEmpleado(Cliente cliente, Playero playero) {
        // Verificar si el empleado está en el Top 10 de empleados del mes anterior
        if (top10PlayerosMesAnterior.contains(playero)) {
            // Aplicar descuento del 10% si no ha sido aplicado antes
            if (!playero.isAplicoDescuento()) {
                playero.aplicarDescuento();
                // Lógica adicional para aplicar el descuento al cliente
                double descuento = 0.10;
                double totalComprasCliente = cliente.getTotalCompras();
                cliente.actualizarTotalCompras(totalComprasCliente * (1 - descuento));
            } else {
                System.out.println("El descuento ya fue aplicado por única vez.");
            }
        }
    }
}
