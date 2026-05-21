package view;

import javax.swing.*;
import model.*;

class VentanaMatricularEstudiante extends JFrame {

    public VentanaMatricularEstudiante() {
        setTitle("Matricular Estudiante");
        setSize(350, 250);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        JLabel lblCodigo = new JLabel("Código Estudiante:");
        lblCodigo.setBounds(20, 30, 140, 30);
        add(lblCodigo);

        JTextField txtCodigo = new JTextField();
        txtCodigo.setBounds(170, 30, 130, 30);
        add(txtCodigo);

        JLabel lblCurso = new JLabel("Curso:");
        lblCurso.setBounds(20, 80, 140, 30);
        add(lblCurso);

        JComboBox<String> cbCursos = new JComboBox<>();
        for (Cursos c : Universidad.CursosUniversidad) {
            cbCursos.addItem(c.getNombre() + " - " + c.getCodigoCurso());
        }
        cbCursos.setBounds(170, 80, 130, 30);
        add(cbCursos);

        JButton btnMatricular = new JButton("Matricular");
        btnMatricular.setBounds(110, 140, 120, 30);
        add(btnMatricular);

        btnMatricular.addActionListener(e -> {
            try {
                int codigo = Integer.parseInt(txtCodigo.getText());

                Estudiante estudianteEncontrado = null;
                for (Estudiante est : Universidad.EstudiantesUniversidad) {
                    if (est.getCodigoEstudiante() == codigo) {
                        estudianteEncontrado = est;
                        break;
                    }
                }

                if (estudianteEncontrado == null) {
                    JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
                    return;
                }

                int indexSeleccionado = cbCursos.getSelectedIndex();
                Cursos cursoSeleccionado = Universidad.CursosUniversidad.get(indexSeleccionado);

                estudianteEncontrado.Matricular(cursoSeleccionado);
                JOptionPane.showMessageDialog(null, "Estudiante matriculado en: " + cursoSeleccionado.getNombre());
                dispose();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingresa un código numérico válido.");
            }
        });

        setVisible(true);
    }
}
