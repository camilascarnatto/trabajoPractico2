package punto3;

public enum Disciplina {
    TANGO("Tango"),
    SALSA("Salsa"),
    BACHATA("Bachata"),
    CLASICO("Clásico"),
    STRETCHING("Stretching"),
    CONTEMPORANEO("Contemporáneo"),
    ARABE("Árabe");

    private final String nombre;

    Disciplina(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
