package punto7;

public class Combustible {
    private String tipo;
    private double precioPorLitro;

    public Combustible(String tipo, double precio){
        this.tipo = tipo;
        this.precioPorLitro = precio;
    }

    public double getPrecioPorLitro() {
        return precioPorLitro;
    }

    public String getTipo() {
        return tipo;
    }
}

