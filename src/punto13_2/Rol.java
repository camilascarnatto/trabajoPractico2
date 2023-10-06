package punto13_2;

public class Rol {
    private int nroVuelo;
    private String rol;

    public Rol(int nroVuelo){
        this.nroVuelo = nroVuelo;
    }

    public int getNroVuelo() {
        return nroVuelo;
    }

    public String getRol() {
        return this.rol;
    }

    protected void setRol(String rol){
        this.rol = rol;
    }

}
