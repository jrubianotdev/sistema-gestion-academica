package model;

public class Cursos {

    private String nombre;
    private int codigoCurso;

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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    @Override
    public String toString() {
        return getNombre() + " - " + codigoCurso;
    }    

}
