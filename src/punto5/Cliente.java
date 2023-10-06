package punto5;

import punto4.Billetera;

public class Cliente {
    String nombre;
    private Billetera billetera;

    public Cliente(String nombre, double saldoInicial, double limiteGiroEnDescubierto){
        this.nombre = nombre;
        this.billetera = new Billetera(saldoInicial, limiteGiroEnDescubierto);
    }

    public String getNombre() {
        return nombre;
    }

    public Billetera getBilletera() {
        return billetera;
    }
}
