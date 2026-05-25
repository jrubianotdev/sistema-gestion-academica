package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.*;

public class VentanaPromedioEstudiante extends JFrame {

    private String[] columnas = { "Código", "Curso", "Nota 1", "Nota 2", "Nota 3", "Final", "Estado" };

    public VentanaPromedioEstudiante() {
        setTitle("Promedio Estudiante");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 450);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblEstudiante = new JLabel("Nombre:");
        lblEstudiante.setBounds(20, 20, 60, 30);
        add(lblEstudiante);

        JComboBox<Estudiante> cbEstudiante = new JComboBox<>();
        for (Estudiante e : Universidad.EstudiantesUniversidad) {
            cbEstudiante.addItem(e);
        }
        cbEstudiante.setBounds(90, 20, 200, 30);
        add(cbEstudiante);

        JButton btnPromedio = new JButton("Promedio Estudiante");
        btnPromedio.setBounds(20, 315, 200, 30);
        add(btnPromedio);

        btnPromedio.addActionListener(e -> {
            Estudiante sel = (Estudiante) cbEstudiante.getSelectedItem();
            if (sel == null)
                return;

            double suma = 0;
            int cantidad = sel.getMatriculas().size();

            if (cantidad == 0) {
                JOptionPane.showMessageDialog(null, "El estudiante no tiene matrículas.");
                return;
            }

            for (Matricula m : sel.getMatriculas()) {
                suma += m.calcularPromedio();
            }

            JOptionPane.showMessageDialog(null,
                    String.format("Promedio del estudiante: %.1f", suma / cantidad));
        });

        JTable tabla = new JTable(crearModelo(new Object[0][7], columnas));
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(20, 70, 550, 230);
        add(scroll);

        Estudiante inicial = (Estudiante) cbEstudiante.getSelectedItem();
        if (inicial != null) {
            actualizarTabla(inicial, tabla);
        }

        cbEstudiante.addActionListener(e -> {
            Estudiante sel = (Estudiante) cbEstudiante.getSelectedItem();
            actualizarTabla(sel, tabla);
        });

        setVisible(true);
    }

    private void actualizarTabla(Estudiante estudiante, JTable tabla) {
        Object[][] datos = new Object[estudiante.getMatriculas().size()][7];

        for (int i = 0; i < estudiante.getMatriculas().size(); i++) {
            Matricula m = estudiante.getMatriculas().get(i);
            datos[i][0] = m.getCurso().getCodigoCurso();
            datos[i][1] = m.getCurso().getNombre();
            datos[i][2] = m.getNotas()[0];
            datos[i][3] = m.getNotas()[1];
            datos[i][4] = m.getNotas()[2];
            datos[i][5] = String.format("%.1f", m.calcularPromedio());
            if(m.aprobo()){
                datos[i][6] = "Aprobado";
            } else {
                datos[i][6] = "Reprobado";
            }
        }

        tabla.setModel(crearModelo(datos, columnas));
    }

    private DefaultTableModel crearModelo(Object[][] datos, String[] columnas) {
        return new DefaultTableModel(datos, columnas) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
    }

}