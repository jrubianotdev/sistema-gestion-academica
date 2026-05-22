package view;

import javax.swing.*;
import model.*;

public class VentanaCursosEstudiante extends JFrame {

    public VentanaCursosEstudiante() {
        setTitle("Cursos del Estudiante");
        setSize(600, 450);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblBuscar = new JLabel("Buscar estudiante:");
        lblBuscar.setBounds(20, 20, 130, 30);
        add(lblBuscar);

        JTextField txtBuscar = new JTextField();
        txtBuscar.setBounds(160, 20, 200, 30);
        add(txtBuscar);

        JComboBox<Estudiante> cbEstudiantes = new JComboBox<>();
        for (Estudiante est : Universidad.EstudiantesUniversidad) {
            cbEstudiantes.addItem(est);
        }
        cbEstudiantes.setBounds(160, 60, 200, 30);
        add(cbEstudiantes);

        String[] columnas = { "Código Curso", "Nombre Curso" };
        Object[][] datosVacios = {};
        JTable tablaCursos = new JTable(datosVacios, columnas);
        JScrollPane scroll = new JScrollPane(tablaCursos);
        scroll.setBounds(20, 110, 540, 250);
        add(scroll);

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent e) {
                String filtro = txtBuscar.getText().toLowerCase();
                cbEstudiantes.removeAllItems();
                for (Estudiante est : Universidad.EstudiantesUniversidad) {
                    if (est.getNombre().toLowerCase().contains(filtro)) {
                        cbEstudiantes.addItem(est);
                    }
                }
            }
        });

        cbEstudiantes.addActionListener(e -> {
            Estudiante seleccionado = (Estudiante) cbEstudiantes.getSelectedItem();
            if (seleccionado == null)
                return;

            Object[][] datos = new Object[seleccionado.getMatriculas().size()][2];
            for (int i = 0; i < seleccionado.getMatriculas().size(); i++) {
                Matricula m = seleccionado.getMatriculas().get(i);
                datos[i][0] = m.getCurso().getCodigoCurso();
                datos[i][1] = m.getCurso().getNombre();
            }

            tablaCursos.setModel(new javax.swing.table.DefaultTableModel(datos, columnas));
        });

        setVisible(true);
    }
}

