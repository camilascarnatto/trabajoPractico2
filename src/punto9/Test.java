package punto9;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        // Crear una lista de figuras
        List<FiguraGeometrica> figuras = new ArrayList<>();
        figuras.add(new Circulo(5));
        figuras.add(new Rectangulo(4, 6));
        figuras.add(new Esfera(3));
        figuras.add(new Cubo(2));
        figuras.add(new Tetraedro(4));

        // Calcular y mostrar áreas para todas las figuras
        System.out.println("Áreas de las figuras en 2D y 3D:");
        for (FiguraGeometrica figura : figuras) {
            System.out.println("Área: " + figura.getArea());
            if (figura instanceof Figura3D) {
                Figura3D forma3D = (Figura3D) figura;
                System.out.println("Volumen: " + forma3D.getVolumen());
            }
            System.out.println("---------");
        }
    }

}
