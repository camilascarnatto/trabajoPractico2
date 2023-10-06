package punto3;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;


public class Academia {
    private String nombre;
    private String direccion;
    private List<Comision> comisiones;
    private List<Alumno> alumnos;
    private List<Profesor> profesores;
    private List<Sala> salas;


    public Academia(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.comisiones = new ArrayList<>();
        this.alumnos = new ArrayList<>();
        this.profesores = new ArrayList<>();
        this.salas = new ArrayList<>();
    }

    public void agregarComision(Comision comision) {
        comisiones.add(comision);
    }

    public void agregarAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }

    public void agregarProfesor(Profesor profesor) {
        profesores.add(profesor);
    }

    public void agregarSala(Sala sala) {
        salas.add(sala);
    }

    public Map<Disciplina, Double> calcularIngresosPorDisciplina() {
        Map<Disciplina, Double> ingresosPorDisciplina = new HashMap<>();

        for (Comision comision : comisiones) {
            Disciplina disciplina = comision.getDisciplina();
            double costoPorDia = 10; // Puedes ajustar el costo por día según tus necesidades

            // Calcular ingresos para esta diagramación
            double ingresosDiagramacion = comision.getAsistencias().size() * costoPorDia;

            // Sumar ingresos al total por disciplina
            ingresosPorDisciplina.put(disciplina, ingresosPorDisciplina.getOrDefault(disciplina, 0.0) + ingresosDiagramacion);
        }

        return ingresosPorDisciplina;
    }

    // Método para obtener la disciplina más rentable
    public Disciplina obtenerDisciplinaMasRentable() {
        Map<Disciplina, Double> ingresosPorDisciplina = new HashMap<>();

        // Inicializar el mapa con todas las disciplinas y cero ingresos
        for (Disciplina disciplina : Disciplina.values()) {
            ingresosPorDisciplina.put(disciplina, 0.0);
        }

        // Calcular ingresos por disciplina
        for (Profesor profesor : profesores) {
            for (Comision comision : profesor.getComisiones()) {
                Disciplina disciplina = comision.getDisciplina();
                double ingresoTotal = comision.getAsistencias().size() * 10.0; // Ingreso por día de asistencia
                ingresosPorDisciplina.put(disciplina, ingresosPorDisciplina.get(disciplina) + ingresoTotal);
            }
        }

        // Encontrar la disciplina con mayores ingresos
        Disciplina disciplinaMasRentable = null;
        double maxIngresos = 0.0;

        for (Map.Entry<Disciplina, Double> entry : ingresosPorDisciplina.entrySet()) {
            if (entry.getValue() > maxIngresos) {
                disciplinaMasRentable = entry.getKey();
                maxIngresos = entry.getValue();
            }
        }

        return disciplinaMasRentable;
    }

}
