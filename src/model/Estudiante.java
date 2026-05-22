package model;

import java.util.*;

import javax.swing.JOptionPane;

public class Estudiante extends Persona {

    private String carrera;
    private int codigoEstudiante;
    private List<Matricula> matriculas = new ArrayList<>();

    public Estudiante(String carrera, String nombre, int edad, char genero) {
        super(nombre, edad, genero);
        this.carrera = carrera;
        this.codigoEstudiante = Universidad.generarCodigoEstudiante();
    }

    public String getCarrera() {
        return carrera;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(int codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public void mostrarInfo() {

        System.out.println("Codigo Estudiante: " + codigoEstudiante + "\n"
                + "Nombre: " + getNombre() + "\n"
                + "Carrera: " + getCarrera());

    }

    public void Matricular(Cursos c) {

        for (Matricula matricula : matriculas) {
            if (c.getCodigoCurso() == matricula.getCurso().getCodigoCurso()) {
                JOptionPane.showMessageDialog(null, "El estudiante ya está matriculado en este curso.");
                return;
            }            
        }
        matriculas.add(new Matricula(c, getCodigoEstudiante()));
        JOptionPane.showMessageDialog(null, "Matriculado exitosamente en " + c.getNombre());

    }

    @Override
    public String toString() {
        return getNombre() + " - " + codigoEstudiante;
    }

}
