package model;

public class Matricula implements Calificable {

    private Cursos curso;
    private int idEstudiante;
    private double[] notas = { 0, 0, 0 };

    public Matricula(Cursos curso, int idEstudiante) {
        this.curso = curso;
        this.idEstudiante = idEstudiante;
    }

    public Cursos getCurso() {
        return curso;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(int indice, double nota) {
        notas[indice] = nota;
    }

    @Override
    public double calcularPromedio() {
        return notas[0] * 0.3 + notas[1] * 0.3 + notas[2] * 0.4;
    }

    @Override
    public boolean aprobo() {
        return calcularPromedio() >= 3.0;
    }

}
