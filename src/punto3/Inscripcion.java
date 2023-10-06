package punto3;

public class Inscripcion {
    private Alumno alumno;
    private Comision comision;
    private String credencial;

    public Inscripcion(Alumno alumno, Comision comision, String credencial) {
        this.alumno = alumno;
        this.comision = comision;
        this.credencial = credencial;
    }

    public String getCredencial() {
        return credencial;
    }

}
