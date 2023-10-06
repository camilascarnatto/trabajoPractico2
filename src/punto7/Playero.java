package punto7;


import java.util.ArrayList;
import java.util.List;

public class Playero {
    private String nombre;
    private boolean aplicoDescuento;

    public Playero(String nombre){
        this.nombre = nombre;
        this.aplicoDescuento = false;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isAplicoDescuento() {
        return aplicoDescuento;
    }

    public void aplicarDescuento(){
        if(!aplicoDescuento) {
            aplicoDescuento = true;
        }
    }
}

