package punto6;

public class Cliente {
    private String patente;
    private double totalCompras;

    public Cliente(String patente){
        this.patente = patente;
        this.totalCompras = 0.0;
    }

    public String getPatente() {
        return patente;
    }

    public double getTotalCompras() {
        return totalCompras;
    }

    public void actualizarTotalCompras(double montoVenta) {
        this.totalCompras += montoVenta;
    }
}
