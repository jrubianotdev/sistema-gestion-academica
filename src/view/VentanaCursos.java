package view;

import javax.swing.*;

public class VentanaCursos extends JFrame {
    public VentanaCursos() {
        setTitle("Cursos");
        setSize(350, 200);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        JButton btnVerCursos = new JButton("Ver Cursos");
        btnVerCursos.setBounds(100, 50, 200, 30);
        add(btnVerCursos);

        btnVerCursos.addActionListener(e -> {
            new VentanaMostrarCursos();
        });

        JButton btnVerEstudiantesCurso = new JButton("Ver Estudiantes del Curso");
        btnVerEstudiantesCurso.setBounds(100, 100, 200, 30);
        add(btnVerEstudiantesCurso);

        btnVerEstudiantesCurso.addActionListener(e -> {
            new VentanaEstudiantesCurso();
        });

        setVisible(true);
    }

}

