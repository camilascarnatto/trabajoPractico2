package punto3;

import java.util.ArrayList;
import java.util.List;

public class Comision {
    private String nombre;
    private String nivel;
    private String dia;
    private String horario;
    private Disciplina disciplina;
    private Profesor profesor;
    private Sala sala;
    private List<Alumno> asistencias;

    public Comision(String dia, String horario, String nivel, Disciplina disciplina, Sala sala, Profesor profesor) {
        this.dia = dia;
        this.horario = horario;
        this.nivel = nivel;
        this.disciplina = disciplina;
        this.sala = sala;
        this.profesor = profesor;
        this.asistencias = new ArrayList<>();
    }

    public void agregarProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void registrarAsistencia(Alumno alumno) {
        asistencias.add(alumno);
    }

    public List<Alumno> getAsistencias() {
        return asistencias;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    // Agregar métodos para calcular ingresos por clase, etc.

}
