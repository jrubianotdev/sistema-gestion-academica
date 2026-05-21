package model;

import java.util.*;

public class Estudiante extends Persona implements Matricula {

    private String carrera;
    private int codigoEstudiante;
    private List<Cursos> CursosEstudiante = new ArrayList<>();

    public Estudiante(String carrera, String nombre, int edad, char genero) {
        super(nombre, edad, genero);
        this.carrera = carrera;
        this.codigoEstudiante = (int) (Math.random() * 2000);
    }

    public String getCarrera() {
        return carrera;
    }

    public List<Cursos> getLista() {
        return CursosEstudiante;
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

        CursosEstudiante.add(c);

    }

    @Override
    public String toString() {
        return getNombre() + " - " + codigoEstudiante;
    }

}
