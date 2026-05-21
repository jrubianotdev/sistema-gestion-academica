package view;

import javax.swing.*;
import model.*;

public class VentanaMostrarCursos extends JFrame {
    public VentanaMostrarCursos() {
        setTitle("Cursos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400); 
        setLocationRelativeTo(null);

        String[] columnas = { "Código", "Nombre" };
        Object[][] datos = new Object[Universidad.CursosUniversidad.size()][2];

        for (int i = 0; i < Universidad.CursosUniversidad.size(); i++) {
            Cursos c = Universidad.CursosUniversidad.get(i);
            datos[i][0] = c.getCodigoCurso();
            datos[i][1] = c.getNombre();
        }

        JTable tabla = new JTable(datos, columnas);
        add(new JScrollPane(tabla));
        setVisible(true);
    }
}

