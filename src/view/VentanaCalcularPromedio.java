package view;

import javax.swing.*;

class VentanaCalcularPromedio extends JFrame{

    public VentanaCalcularPromedio() {
        setTitle("Calcular Promedio");
        setSize(350, 200);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        JButton btnPromedioCurso = new JButton("Promedio Curso");
        btnPromedioCurso.setBounds(100, 50, 200, 30);
        add(btnPromedioCurso);

        btnPromedioCurso.addActionListener(e -> {
            new VentanaPromedioCurso();
        });        

        JButton btnPromedioEstudiante = new JButton("Promedio Estudiante");
        btnPromedioEstudiante.setBounds(100, 100, 200, 30);
        add(btnPromedioEstudiante);        

        btnPromedioEstudiante.addActionListener(e -> {
            new VentanaPromedioEstudiante();
        });        

        setVisible(true);
    }
}