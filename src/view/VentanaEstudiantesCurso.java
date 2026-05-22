package view;

import javax.swing.*;
import java.util.*;
import model.*;

public class VentanaEstudiantesCurso extends JFrame {
    public VentanaEstudiantesCurso() {
        setTitle("Estudiantes del Curso");
        setSize(600, 450);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblBuscar = new JLabel("Buscar Curso:");
        lblBuscar.setBounds(20, 20, 130, 30);
        add(lblBuscar);

        JTextField txtBuscar = new JTextField();
        txtBuscar.setBounds(160, 20, 200, 30);
        add(txtBuscar);

        JComboBox<Cursos> cbCursos = new JComboBox<>();
        for (Cursos est : Universidad.CursosUniversidad) {
            cbCursos.addItem(est);
        }
        cbCursos.setBounds(160, 60, 200, 30);
        add(cbCursos);

        String[] columnas = { "Código Estudiante", "Nombre", "Carrera" };
        Object[][] datosVacios = {};
        JTable tablaCursos = new JTable(datosVacios, columnas);
        JScrollPane scroll = new JScrollPane(tablaCursos);
        scroll.setBounds(20, 110, 540, 250);
        add(scroll);

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent e) {
                String filtro = txtBuscar.getText().toLowerCase();
                cbCursos.removeAllItems();
                for (Cursos est : Universidad.CursosUniversidad) {
                    if (est.getNombre().toLowerCase().contains(filtro)) {
                        cbCursos.addItem(est);
                    }
                }
            }
        });

        cbCursos.addActionListener(e -> {
            Cursos seleccionado = (Cursos) cbCursos.getSelectedItem();
            if (seleccionado == null)
                return;

            List<Estudiante> matriculados = new ArrayList<>();
            for (Estudiante est : Universidad.EstudiantesUniversidad) {
                for (Matricula m : est.getMatriculas()) {
                    if (m.getCurso().getCodigoCurso() == seleccionado.getCodigoCurso()) {
                        matriculados.add(est);
                        break;
                    }
                }
            }

            Object[][] datos = new Object[matriculados.size()][3];
            for (int i = 0; i < matriculados.size(); i++) {
                Estudiante est = matriculados.get(i);
                datos[i][0] = est.getCodigoEstudiante();
                datos[i][1] = est.getNombre();
                datos[i][2] = est.getCarrera();
            }

            tablaCursos.setModel(new javax.swing.table.DefaultTableModel(datos, columnas));
        });

        setVisible(true);
    }

}

