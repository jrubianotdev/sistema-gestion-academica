package view;

import javax.swing.*;
import model.*;

public class VentanaMostrarEstudiantes extends JFrame {
    public VentanaMostrarEstudiantes() {
        setTitle("Estudiantes");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400); 
        setLocationRelativeTo(null);

        String[] columnas = { "Código", "Nombre", "Carrera", "Edad" };
        Object[][] datos = new Object[Universidad.EstudiantesUniversidad.size()][4];

        for (int i = 0; i < Universidad.EstudiantesUniversidad.size(); i++) {
            Estudiante est = Universidad.EstudiantesUniversidad.get(i);
            datos[i][0] = est.getCodigoEstudiante();
            datos[i][1] = est.getNombre();
            datos[i][2] = est.getCarrera();
            datos[i][3] = est.getEdad();
        }

        JTable tabla = new JTable(datos, columnas);
        add(new JScrollPane(tabla));
        setVisible(true);
    }
}
