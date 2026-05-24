package view;

import javax.swing.*;
import model.*;
import java.awt.event.*;

class VentanaRegistroEstudiante extends JFrame {

    public VentanaRegistroEstudiante() {

        setTitle("Registro Estudiante");
        setSize(400, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 30, 100, 30);
        add(lblNombre);

        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(140, 30, 180, 30);
        add(txtNombre);

        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(30, 80, 100, 30);
        add(lblEdad);

        JTextField txtEdad = new JTextField();
        txtEdad.setBounds(140, 80, 180, 30);
        add(txtEdad);

        txtEdad.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {

                char c = e.getKeyChar();

                if (!Character.isDigit(c)) {
                    e.consume();
                }

            }

        });        

        JLabel lblGenero = new JLabel("Genero:");
        lblGenero.setBounds(30, 130, 100, 30);
        add(lblGenero);

        JComboBox<String> cmbGeneros = new JComboBox<>(new String[] {"Masculino", "Femenino"});
        cmbGeneros.setBounds(140, 130, 180, 30);
        add(cmbGeneros);         

        JLabel lblCarrera = new JLabel("Carrera:");
        lblCarrera.setBounds(30, 180, 100, 30);
        add(lblCarrera);

        JComboBox<String> cmbCarreras = new JComboBox<>(new String[] {"Derecho", "Ingeniería de Sistemas", "Contaduría Pública", "Ingeniería Industrial",
        "Medicina", "Fisioterapia", "Microbilogía", "Bacteriología", "Instrumentación Quirúrgica", "Administración de Negocios Internacionales", "Turismo"});
        cmbCarreras.setBounds(140, 180, 180, 30);
        add(cmbCarreras);             

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(140, 230, 120, 30);
        add(btnGuardar);

        btnGuardar.addActionListener(e -> {

            if (txtNombre.getText().isBlank() || txtEdad.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "No pueden haber campos vacíos.");
                return;
            }

            String nombre = txtNombre.getText();
            int edad;
            try {

                edad = Integer.parseInt(txtEdad.getText());

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null,"La edad debe ser un número entero.");
                return;
            }

            String carrera = cmbCarreras.getSelectedItem().toString();
            char genero = cmbGeneros.getSelectedItem().toString().charAt(0);

            Estudiante nuevoEstudiante = new Estudiante(carrera, nombre, edad, genero);

            Universidad.EstudiantesUniversidad.add(nuevoEstudiante);

            JOptionPane.showMessageDialog(null,
                    "Estudiante registrado:\n" +
                            nombre + "\n" +
                            edad + "\n" +
                            genero + "\n" +
                            carrera);

            dispose();
        });

        setVisible(true);
    }
}
