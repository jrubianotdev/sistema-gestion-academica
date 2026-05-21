package model;

public class Cursos {

    private String nombre;
    private int codigoCurso;
    private double notas[] = new double[3];

    public Cursos(String nombre, int codigoCurso) {
        this.nombre = nombre;
        this.codigoCurso = codigoCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return getNombre() + " - " + codigoCurso;
    }    

}
