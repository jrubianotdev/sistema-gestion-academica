package view;

import javax.swing.*;
import model.*;

public class VentanaRegistrarNotasPorCurso extends JFrame{

        public VentanaRegistrarNotasPorCurso() {
        setTitle("Cursos");
        setSize(600, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);    

        JLabel lblCurso = new JLabel("Curso:");
        lblCurso.setBounds(20, 80, 140, 30);
        add(lblCurso);        

        JComboBox<String> cbCursos = new JComboBox<>();
        for (Cursos c : Universidad.CursosUniversidad) {
            cbCursos.addItem(c.getNombre() + " - " + c.getCodigoCurso());
        }
        cbCursos.setBounds(170, 80, 130, 30);
        add(cbCursos);

        String[] columnas = { "Código", "Nombre", "Nota 1", "Nota 2", "Nota 3"};
        Object[][] datos = new Object[Universidad.EstudiantesUniversidad.size()][5];

        for (int i = 0; i < Universidad.EstudiantesUniversidad.size(); i++) {
            Estudiante est = Universidad.EstudiantesUniversidad.get(i);
            datos[i][0] = est.getCodigoEstudiante();
            datos[i][1] = est.getNombre();
            datos[i][2] = "";
            datos[i][3] = "";
            datos[i][3] = "";
        }

        JTable tabla = new JTable(datos, columnas);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(20, 130, 300, 150);
        add(scroll);                

        setVisible(true);

    }   

}
