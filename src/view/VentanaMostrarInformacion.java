package view;

import javax.swing.*;

public class VentanaMostrarInformacion extends JFrame {
    public VentanaMostrarInformacion() {
        setTitle("Visualización");
        setSize(350, 200);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        JButton btnEstudiantes = new JButton("Estudiantes");
        btnEstudiantes.setBounds(100, 50, 200, 30);
        add(btnEstudiantes);

        btnEstudiantes.addActionListener(e -> {
            new VentanaEstudiantes();
        });

        JButton btnCursos = new JButton("Cursos");
        btnCursos.setBounds(100, 100, 200, 30);
        add(btnCursos);

        btnCursos.addActionListener(e -> {
            new VentanaCursos();
        });

        setVisible(true);
    }
}
