package view;

import javax.swing.*;
import model.*;

public class VentanaRegistrarNotasPorCurso extends JFrame{

        public VentanaRegistrarNotasPorCurso() {
        setTitle("Cursos");
        setSize(350, 250);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);    

        JLabel lblCurso = new JLabel("Curso:");
        lblCurso.setBounds(20, 80, 140, 30);
        add(lblCurso);        

        JComboBox<String> cbCursos = new JComboBox<>();
        for (Cursos c : Universidad.CursosUniversidad) {
            cbCursos.addItem(c.getNombre() + " - " + c.getCodigoCurso());
        }
        cbCursos.setBounds(170, 80, 130, 30);
        add(cbCursos);


        setVisible(true);

    }   

}
