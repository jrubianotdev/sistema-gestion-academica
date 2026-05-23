package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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

        JTable tabla = new JTable(crearModelo(datos, columnas));     
        add(new JScrollPane(tabla));
        setVisible(true);
    }

        private DefaultTableModel crearModelo(Object[][] datos, String [] columnas){
            return new DefaultTableModel(datos,columnas){
                @Override
                public boolean isCellEditable(int fila, int columna){
                    return false;
                }
            };
        }
}
