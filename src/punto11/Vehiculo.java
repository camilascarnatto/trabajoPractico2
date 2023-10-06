package punto11;

public class Vehiculo {

    private String patente;
    private float precioBase = 3000;
    private boolean disponible;

    public Vehiculo(String patente){
        this.patente = patente;
        this.disponible = true;

    }

    public boolean estaDisponible(){
        return disponible;
    }
    public float getPrecioBase() {
        return precioBase;
    }



    public String getPatente() {
        return patente;
    }

    public float alquilar(int dias){
        if(disponible){
            this.disponible = false;
            return calcularPrecio(dias);
        }else throw new IllegalStateException("No es posible alquilar");

    }

    public float calcularPrecio(int dias){
        return this.precioBase * dias;
    }

    public float calcularPrecioDiario(){
        return precioBase;
    }

    public void setPrecioBase(float precioBase) {
        this.precioBase = precioBase;
    }


}
