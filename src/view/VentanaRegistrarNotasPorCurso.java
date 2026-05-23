package view;

import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import model.*;

public class VentanaRegistrarNotasPorCurso extends JFrame{

        public VentanaRegistrarNotasPorCurso() {
        setTitle("Registrar Notas por Curso");
        setSize(600, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);    

        JLabel lblCurso = new JLabel("Curso:");
        lblCurso.setBounds(20, 20, 60, 30);
        add(lblCurso);        

        JComboBox<Cursos> cbCursos = new JComboBox<>();
        for (Cursos c : Universidad.CursosUniversidad) {
            cbCursos.addItem(c);
        }
        cbCursos.setBounds(90, 20, 200, 30);
        add(cbCursos);

        String[] columnas = { "Código", "Nombre", "Nota 1", "Nota 2", "Nota 3"};
        Object[][] datosVacios = {};
        JTable tabla = new JTable(crearModelo(datosVacios, columnas));
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(20, 70, 550, 230);
        add(scroll);              

        cbCursos.addActionListener( e -> {
            Cursos seleccionado = (Cursos) cbCursos.getSelectedItem();
            if (seleccionado == null) return;

            List<Estudiante> matriculados = new ArrayList<>();
            for (Estudiante est : Universidad.EstudiantesUniversidad) {
                for (Matricula m : est.getMatriculas()) {
                    if (m.getCurso().getCodigoCurso() == seleccionado.getCodigoCurso()) {
                        matriculados.add(est);
                        break;
                    }
                }
            }

        Object[][] datos = new Object[matriculados.size()][5];
        for (int i = 0; i < matriculados.size(); i++) {
            Estudiante est = matriculados.get(i);
            datos[i][0] = est.getCodigoEstudiante();
            datos[i][1] = est.getNombre();
            datos[i][2] = "";
            datos[i][3] = "";
            datos[i][4] = "";
        }

        tabla.setModel(crearModelo(datos, columnas));
        });

        setVisible(true);

    }   

    private DefaultTableModel crearModelo(Object[][] datos, String [] columnas){
        return new DefaultTableModel(datos,columnas){
            @Override
            public boolean isCellEditable(int fila, int columna){
                return columna >=2;
            }
        };
    }

}
