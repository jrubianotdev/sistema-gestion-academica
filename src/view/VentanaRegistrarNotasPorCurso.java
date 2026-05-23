package view;

import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import model.*;

public class VentanaRegistrarNotasPorCurso extends JFrame{

        public VentanaRegistrarNotasPorCurso() {
        setTitle("Registrar Notas por Curso");
        setSize(600, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);    

        JLabel lblCurso = new JLabel("Curso:");
        lblCurso.setBounds(20, 20, 60, 30);
        add(lblCurso);        

        JComboBox<Cursos> cbCursos = new JComboBox<>();
        for (Cursos c : Universidad.CursosUniversidad) {
            cbCursos.addItem(c);
        }
        cbCursos.setBounds(90, 20, 200, 30);
        add(cbCursos);

        JButton btnGuardarNotas = new JButton("Guardar Notas");
        btnGuardarNotas.setBounds(240, 320, 120, 30);
        add(btnGuardarNotas);       

        String[] columnas = { "Código", "Nombre", "Nota 1", "Nota 2", "Nota 3"};
        Object[][] datosVacios = {};
        JTable tabla = new JTable(crearModelo(datosVacios, columnas));
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(20, 70, 550, 230);
        add(scroll);              

        cbCursos.addActionListener( e -> {
            Cursos seleccionado = (Cursos) cbCursos.getSelectedItem();

            List<Estudiante> matriculados = new ArrayList<>();
            for (Estudiante est : Universidad.EstudiantesUniversidad) {
                for (Matricula m : est.getMatriculas()) {
                    if (m.getCurso().getCodigoCurso() == seleccionado.getCodigoCurso()) {
                        matriculados.add(est);
                        break;
                    }
                }
            }

        Object[][] datos = new Object[matriculados.size()][5];
        for (int i = 0; i < matriculados.size(); i++) {
            Estudiante est = matriculados.get(i);

            double [] notas = {0,0,0};

            for (Matricula m : est.getMatriculas()) {
                if (m.getCurso().getCodigoCurso() == seleccionado.getCodigoCurso()) {
                    notas = m.getNotas();
                    break;
                }
            }
            datos[i][0] = est.getCodigoEstudiante();
            datos[i][1] = est.getNombre();
            datos[i][2] = notas[0];
            datos[i][3] = notas[1];
            datos[i][4] = notas[2];
        }

        tabla.setModel(crearModelo(datos, columnas));
        });

        btnGuardarNotas.addActionListener(e -> {

            int indexCurso = cbCursos.getSelectedIndex();
            if (indexCurso == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione un curso.");
                return;
            }

            if (tabla.isEditing()) {
                tabla.getCellEditor().stopCellEditing();
            }

            Cursos seleccionado = (Cursos) cbCursos.getSelectedItem();

            if (seleccionado == null) {
                return;
            }

            DefaultTableModel model = (DefaultTableModel) tabla.getModel();

            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "No hay estudiantes matriculados en este curso.");
                return;
            }

            for (int i = 0; i < model.getRowCount(); i++){

                int codigo = Integer.parseInt(model.getValueAt(i, 0).toString());

                double nota1 = Double.parseDouble(model.getValueAt(i, 2).toString());
                double nota2 = Double.parseDouble(model.getValueAt(i, 3).toString());
                double nota3 = Double.parseDouble(model.getValueAt(i, 4).toString());                
                
                for (Estudiante est : Universidad.EstudiantesUniversidad) {
                    if (est.getCodigoEstudiante() == codigo) {
                        
                        for (Matricula m : est.getMatriculas()) {

                            if (m.getCurso().getCodigoCurso() == seleccionado.getCodigoCurso()) {

                                m.setNotas(0, nota1);
                                m.setNotas(1, nota2);
                                m.setNotas(2, nota3);
                                break;                                

                            }
                            
                        }
                        break;
                    }

                }

            }

            JOptionPane.showMessageDialog(null, "Notas registradas exitosamente");
            dispose();

        });      

        setVisible(true);

    }   

    private DefaultTableModel crearModelo(Object[][] datos, String [] columnas){
        return new DefaultTableModel(datos,columnas){
            @Override
            public boolean isCellEditable(int fila, int columna){
                return columna >=2;
            }
        };
    }

}
