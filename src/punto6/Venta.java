package punto6;

import java.time.LocalDate;
import java.util.Date;

public class Venta {
    private String patente;
    private Cliente cliente;
    private Combustible tipoCombustible;
    private double litrosExpedidos;
    private double totalVenta;
    private Playero playero;
    private LocalDate fecha;

    public Venta(Cliente cliente, Combustible combustible, double total, double litros, Playero playero, LocalDate fecha){
        this.cliente = cliente;
        this.patente = cliente.getPatente();
        this.totalVenta = total;
        this.litrosExpedidos = litros;
        this.tipoCombustible = combustible;
        this.playero = playero;
        this.fecha = fecha;
    }


    public Combustible getTipoCombustible() {
        return tipoCombustible;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public Playero getPlayero() {
        return playero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getPatente() {
        return patente;
    }



    public double getLitrosExpendidos() {
        return litrosExpedidos;
    }

    public LocalDate getFecha() {
        return fecha;
    }
}
