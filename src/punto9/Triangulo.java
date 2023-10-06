package punto9;

public class Triangulo extends  Figura2D{
    private double base;
    private double altura;
    public Triangulo(double base, double altura){
        this.base = base;
        this.altura = altura;
    }
    @Override
    public double getArea() {
        return 0.5 * base * altura;
    }
}
