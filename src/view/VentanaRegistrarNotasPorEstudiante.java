package view;

import javax.swing.*;
import model.*;
import javax.swing.table.*;

public class VentanaRegistrarNotasPorEstudiante extends JFrame {

    public VentanaRegistrarNotasPorEstudiante() {
        setTitle("Registrar Notas por Estudiante");
        setSize(600, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        JLabel lblEstudiante = new JLabel("Nombre:");
        lblEstudiante.setBounds(20, 20, 60, 30);
        add(lblEstudiante);

        JComboBox<Estudiante> cbEstudiante = new JComboBox<>();
        for (Estudiante e : Universidad.EstudiantesUniversidad) {
            cbEstudiante.addItem(e);
        }
        cbEstudiante.setBounds(90, 20, 200, 30);
        add(cbEstudiante);

        JButton btnGuardarNotas = new JButton("Guardar Notas");
        btnGuardarNotas.setBounds(240, 320, 120, 30);
        add(btnGuardarNotas);

        String[] columnas = { "Código", "Curso", "Nota 1", "Nota 2", "Nota 3" };
        Object[][] datosVacios = {};
        JTable tabla = new JTable(crearModelo(datosVacios, columnas));
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(20, 70, 550, 230);
        add(scroll);

        cbEstudiante.addActionListener(e -> {

            Estudiante seleccionado = (Estudiante) cbEstudiante.getSelectedItem();

            if (seleccionado == null) {
                return;
            }

            Object[][] datos = new Object[seleccionado.getMatriculas().size()][5];

            for (int i = 0; i < seleccionado.getMatriculas().size(); i++) {

                Matricula m = seleccionado.getMatriculas().get(i);

                datos[i][0] = m.getCurso().getCodigoCurso();
                datos[i][1] = m.getCurso().getNombre();
                datos[i][2] = m.getNotas()[0];
                datos[i][3] = m.getNotas()[1];
                datos[i][4] = m.getNotas()[2];
            }

            tabla.setModel(crearModelo(datos, columnas));
        });

        btnGuardarNotas.addActionListener(e -> {

            int indexEstudiante = cbEstudiante.getSelectedIndex();
            if (indexEstudiante == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione un estudiante.");
                return;
            }

            if (tabla.isEditing()) {
                tabla.getCellEditor().stopCellEditing();
            }

            Estudiante seleccionado = (Estudiante) cbEstudiante.getSelectedItem();

            DefaultTableModel model = (DefaultTableModel) tabla.getModel();

            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "No hay cursos matriculados para este estudiante.");
                return;
            }

            for (int i = 0; i < model.getRowCount(); i++) {

                double nota1 = Double.parseDouble(model.getValueAt(i, 2).toString());
                double nota2 = Double.parseDouble(model.getValueAt(i, 3).toString());
                double nota3 = Double.parseDouble(model.getValueAt(i, 4).toString());

                Matricula m = seleccionado.getMatriculas().get(i);

                m.setNotas(0, nota1);
                m.setNotas(1, nota2);
                m.setNotas(2, nota3);

            }

            JOptionPane.showMessageDialog(null, "Notas registradas exitosamente");
            dispose();

        });

        setVisible(true);

    }

    private DefaultTableModel crearModelo(Object[][] datos, String[] columnas) {
        return new DefaultTableModel(datos, columnas) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return columna >= 2;
            }
        };
    }

}
