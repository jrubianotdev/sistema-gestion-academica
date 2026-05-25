package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.*;

public class VentanaPromedioCurso extends JFrame {

    private String[] columnas = { "Código Estudiante", "Nombre", "Nota 1", "Nota 2", "Nota 3", "Final" };

    public VentanaPromedioCurso() {
        setTitle("Promedio Curso");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblCurso = new JLabel("Curso:");
        lblCurso.setBounds(20, 20, 60, 30);
        add(lblCurso);

        JComboBox<Cursos> cbCurso = new JComboBox<>();
        for (Cursos c : Universidad.CursosUniversidad) {
            cbCurso.addItem(c);
        }
        cbCurso.setBounds(90, 20, 200, 30);
        add(cbCurso);

        JTable tabla = new JTable(crearModelo(new Object[0][6], columnas));
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(20, 70, 550, 230);
        add(scroll);

        JButton btnPromedio = new JButton("Promedio Curso ");
        btnPromedio.setBounds(20, 315, 200, 30);
        add(btnPromedio);

        Cursos inicial = (Cursos) cbCurso.getSelectedItem();
        if (inicial != null) {
            actualizarTabla(inicial, tabla);
        }

        cbCurso.addActionListener(e -> {
            Cursos sel = (Cursos) cbCurso.getSelectedItem();
            actualizarTabla(sel, tabla);
        });

        btnPromedio.addActionListener(e -> {
            Cursos sel = (Cursos) cbCurso.getSelectedItem();
            if (sel == null)
                return;

            double suma = 0;
            int cantidad = 0;

            for (Estudiante est : Universidad.EstudiantesUniversidad) {
                for (Matricula m : est.getMatriculas()) {
                    if (m.getCurso().getCodigoCurso() == sel.getCodigoCurso()) {
                        suma += m.calcularPromedio();
                        cantidad++;
                    }
                }
            }

            if (cantidad == 0) {
                JOptionPane.showMessageDialog(null, "No hay estudiantes en este curso.");
                return;
            }

            JOptionPane.showMessageDialog(null,
                    String.format("Promedio del curso: %.1f", suma / cantidad));
        });

        setVisible(true);
    }

    private void actualizarTabla(Cursos curso, JTable tabla) {
        java.util.List<Object[]> filas = new java.util.ArrayList<>();

        for (Estudiante est : Universidad.EstudiantesUniversidad) {
            for (Matricula m : est.getMatriculas()) {
                if (m.getCurso().getCodigoCurso() == curso.getCodigoCurso()) {
                    Object[] fila = new Object[6];
                    fila[0] = est.getCodigoEstudiante();
                    fila[1] = est.getNombre();
                    fila[2] = m.getNotas()[0];
                    fila[3] = m.getNotas()[1];
                    fila[4] = m.getNotas()[2];
                    fila[5] = String.format("%.1f", m.calcularPromedio());
                    filas.add(fila);
                }
            }
        }

        Object[][] datos = filas.toArray(new Object[0][]);
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