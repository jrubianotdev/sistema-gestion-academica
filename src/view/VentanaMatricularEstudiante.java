package view;

import javax.swing.*;
import model.*;
import java.awt.event.*;

class VentanaMatricularEstudiante extends JFrame {

    public VentanaMatricularEstudiante() {
        setTitle("Matricular Estudiante");
        setSize(400, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        JLabel lblBuscar = new JLabel("Buscar:");
        lblBuscar.setBounds(30, 30 , 100, 30);
        add(lblBuscar);        

        JTextField txtBuscar = new JTextField();
        txtBuscar.setBounds(140, 30, 180, 30);
        add(txtBuscar);

        JLabel lblEstudiante = new JLabel("Estudiante:");
        lblEstudiante.setBounds(30, 80 , 100, 30);
        add(lblEstudiante);        

        JComboBox<Estudiante> cmbEstudiantes = new JComboBox<>();
        for (Estudiante est : Universidad.EstudiantesUniversidad) {
            cmbEstudiantes.addItem(est);
        }
        cmbEstudiantes.setBounds(140, 80, 180, 30);
        add(cmbEstudiantes);
        
        txtBuscar.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String filtro = txtBuscar.getText().toLowerCase();
                cmbEstudiantes.removeAllItems();
                for (Estudiante est : Universidad.EstudiantesUniversidad) {
                    if (est.getNombre().toLowerCase().contains(filtro)) {
                        cmbEstudiantes.addItem(est);
                    }
                }
            }
        });        

        JLabel lblCurso = new JLabel("Curso:");
        lblCurso.setBounds(30, 130, 180, 30);
        add(lblCurso);

        JComboBox<String> cbCursos = new JComboBox<>();
        for (Cursos c : Universidad.CursosUniversidad) {
            cbCursos.addItem(c.getNombre() + " - " + c.getCodigoCurso());
        }
        cbCursos.setBounds(140, 130, 180, 30);
        add(cbCursos);

        JButton btnMatricular = new JButton("Matricular");
        btnMatricular.setBounds(140, 180, 120, 30);
        add(btnMatricular);

btnMatricular.addActionListener(e -> {

    int indexEstudiante = cmbEstudiantes.getSelectedIndex();
    int indexCurso = cbCursos.getSelectedIndex();

    if (indexEstudiante == -1) {
        JOptionPane.showMessageDialog(null,"Seleccione un estudiante");
        return;
    }

    if (indexCurso == -1) {
        JOptionPane.showMessageDialog(null,"Seleccione un curso");
        return;
    }    

    Estudiante estudianteSeleccionado = Universidad.EstudiantesUniversidad.get(indexEstudiante);
    Cursos cursoSeleccionado = Universidad.CursosUniversidad.get(indexCurso);

    estudianteSeleccionado.Matricular(cursoSeleccionado);
    JOptionPane.showMessageDialog(null, "Estudiante matriculado en: " + cursoSeleccionado.getNombre());
    dispose();

});
        setVisible(true);
    }
}
