package view;

import javax.swing.*;

class VentanaRegistrarNota extends JFrame{

    public VentanaRegistrarNota() {
        setTitle("Registrar Nota");
        setSize(350, 250);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false); 

        JButton btnRegistrarNotasPorCurso = new JButton("Registrar Notas por Curso");
        btnRegistrarNotasPorCurso.setBounds(100, 50, 200, 30);
        add(btnRegistrarNotasPorCurso);

        btnRegistrarNotasPorCurso.addActionListener(e -> {
            new VentanaRegistrarNotasPorCurso();
        });

        JButton btnRegistrarNotasPorEstudiante = new JButton("Registrar Notas Por Estudiante");
        btnRegistrarNotasPorEstudiante.setBounds(100, 100, 200, 30);
        add(btnRegistrarNotasPorEstudiante);

        btnRegistrarNotasPorEstudiante.addActionListener(e -> {
            new VentanaRegistrarNotasPorEstudiante();
        });        
        
        setVisible(true);
        
    }

}
