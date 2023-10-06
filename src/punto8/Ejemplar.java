package punto8;

public class Ejemplar {
    private int nroEjemplar;
    private boolean isPrestado;

    public Ejemplar(int nroEjemplar){
        this.nroEjemplar = nroEjemplar;
        isPrestado = false;
    }

    public boolean estaPrestado(){
        return isPrestado;
    }

    public boolean prestar(){
        if (isPrestado){
            return false;
        }
        isPrestado = true;
        return true;
    }

    public boolean devolver(){
        if (!isPrestado){
            return false;
        }
        isPrestado = false;
        return  true;
    }

    public int getNroEjemplar() {
        return nroEjemplar;
    }
}
