package punto9;

public class Circulo extends Figura2D{
    private double radio;

    public Circulo(double radio){
        this.radio = radio;
    }
    @Override
    public double getArea() {
        return Math.PI * radio * radio;
    }
}
