package view;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {

        setTitle("Sistema Universidad");
        setSize(400, 430);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JButton btnRegistrar = new JButton("Registrar Estudiante");
        btnRegistrar.setBounds(100, 50, 200, 30);
        add(btnRegistrar);

        btnRegistrar.addActionListener(e -> {
            new VentanaRegistroEstudiante();
        });

        JButton btnCrearCurso = new JButton("Crear Curso");
        btnCrearCurso.setBounds(100, 100, 200, 30);
        add(btnCrearCurso);

        btnCrearCurso.addActionListener(e -> {
            new VentanaCrearCurso();
        });

        JButton btnMatricularEstudiante = new JButton("Matricular Estudiante");
        btnMatricularEstudiante.setBounds(100, 150, 200, 30);
        add(btnMatricularEstudiante);

        btnMatricularEstudiante.addActionListener(e -> {
            new VentanaMatricularEstudiante();
        });

        JButton btnRegistrarNota = new JButton("Registrar Nota");
        btnRegistrarNota.setBounds(100, 200, 200, 30);
        add(btnRegistrarNota);

        btnRegistrarNota.addActionListener(e -> {
            new VentanaRegistrarNota();
        });
        
        JButton btnCalcularPromedio= new JButton("Calcular Promedio");
        btnCalcularPromedio.setBounds(100, 250, 200, 30);
        add(btnCalcularPromedio);

        btnCalcularPromedio.addActionListener(e -> {
            new VentanaCalcularPromedio();
        });             

        JButton btnMostrarInformacion = new JButton("Mostrar Informacion");
        btnMostrarInformacion.setBounds(100, 300, 200, 30);
        add(btnMostrarInformacion);

        btnMostrarInformacion.addActionListener(e -> {
            new VentanaMostrarInformacion();
        });

        setVisible(true);

    }

}

