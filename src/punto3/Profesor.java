package punto3;

import java.util.ArrayList;
import java.util.List;


public class Profesor {
    private String nombre;
    private String contacto;
    private List<Disciplina> disciplinas;
    private List<Comision> comisiones;

    public Profesor(String nombre, String contacto) {
        this.nombre = nombre;
        this.contacto = contacto;
        this.disciplinas = new ArrayList<>();
        this.comisiones = new ArrayList<>();
    }

    public void agregarComision(Comision comision) {
        comisiones.add(comision);
    }
    public void agregarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public double calcularPago(List<Comision> comisiones, int costoPorDia) {
        int totalDiasAsistencia = 0;

        for (Comision comision : comisiones) {
            if (comision.getProfesor() == this) {
                // Verificar si el profesor está asignado a esta diagramación
                totalDiasAsistencia += comision.getAsistencias().size();
            }
        }

        return totalDiasAsistencia * costoPorDia;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public List<Comision> getComisiones() {
        return comisiones;
    }

}
