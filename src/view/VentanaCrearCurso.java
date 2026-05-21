package view;

import javax.swing.*;
import model.*;

class VentanaCrearCurso extends JFrame {
    public VentanaCrearCurso() {
        setTitle("Crear Nuevo Curso");
        setSize(350, 200);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        JLabel lblNombre = new JLabel("Nombre Curso:");
        lblNombre.setBounds(20, 30, 100, 30);
        add(lblNombre);

        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(140, 30, 180, 30);
        add(txtNombre);

        JButton btnCrear = new JButton("Crear");
        btnCrear.setBounds(140, 80, 100, 30);
        add(btnCrear);

        btnCrear.addActionListener(e -> {
            String nombre = txtNombre.getText();
            int codigo = (int) (Math.random() * 2000);
            Cursos nuevoCurso = new Cursos(nombre, codigo);
            Universidad.CursosUniversidad.add(nuevoCurso);
            JOptionPane.showMessageDialog(this, "Curso '" + nombre + "' creado con código: " + codigo);
            dispose();
        });
        setVisible(true);
    }
}

