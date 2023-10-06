package punto9;

public class Esfera extends Figura3D{

    private double radio;

    public Esfera(double radio){
        this.radio = radio;
    }

    @Override
    double getVolumen() {
        return 4 * Math.PI * radio * radio;
    }

    @Override
    public double getArea() {
        return (4.0 / 3.0) * Math.PI * radio * radio * radio;
    }
}
