package punto9;

public class Tetraedro extends Figura3D{
    private double arista;

    public Tetraedro(double arista){
        this.arista = arista;
    }

    @Override
    double getVolumen() {
        return (arista * arista * arista * Math.sqrt(2)) / 12.0;
    }

    @Override
    public double getArea() {
        return arista * arista * Math.sqrt(3);
    }
}
