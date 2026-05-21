package model;

import java.util.*;

public class Universidad {

    private static int contadorEstudiantes = 1000;
    private static int contadorCursos = 2000;

    public static List<Estudiante> EstudiantesUniversidad = new ArrayList<>();
    public static List<Cursos> CursosUniversidad = new ArrayList<>();

    public static int generarCodigoEstudiante(){
        return ++contadorEstudiantes;
    }

    public static int generarCodigoCurso(){
        return ++contadorCursos;
    }

}