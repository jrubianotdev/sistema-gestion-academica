package view;

import javax.swing.*;

public class VentanaEstudiantes extends JFrame {
    public VentanaEstudiantes() {
        setTitle("Estudiantes");
        setSize(350, 200);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        JButton btnVerEstudiantes = new JButton("Ver Estudiantes");
        btnVerEstudiantes.setBounds(100, 50, 200, 30);
        add(btnVerEstudiantes);

        btnVerEstudiantes.addActionListener(e -> {
            new VentanaMostrarEstudiantes();
        });

        JButton btnVerCursosEstudiante = new JButton("Ver Cursos del Estudiante");
        btnVerCursosEstudiante.setBounds(100, 100, 200, 30);
        add(btnVerCursosEstudiante);

        btnVerCursosEstudiante.addActionListener(e -> {
            new VentanaCursosEstudiante();
        });

        setVisible(true);
    }

}
