package Circunferencia;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ventana extends JFrame {
    JLabel etiquetaRadio, etiquetaArea, etiquetaPerimetro;
    JButton botonCerrar;
    JTextField formularioRadio, formularioArea, formularioPerimetro;
    GridBagConstraints gridBagConstraints;
    Container container;

    public Ventana() {
        super("Calculo");
        this.setSize(250, 150);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        container = getContentPane();
        container.setLayout(new GridBagLayout());
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(1, 1, 1, 1);

        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 1;

        gridBagConstraints.anchor = GridBagConstraints.LAST_LINE_START;

        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridx = 0;

        etiquetaRadio = new JLabel("Radio : ");
        container.add(etiquetaRadio, gridBagConstraints);
        formularioRadio = new JTextField(5);
        /* formularioArea.selectAll(); */

        gridBagConstraints.gridx = 1;
        container.add(formularioRadio, gridBagConstraints);

        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridx = 0;

        etiquetaArea = new JLabel("Area : ");
        container.add(etiquetaArea, gridBagConstraints);
        formularioArea = new JTextField(5);
        formularioArea.setEditable(false);

        gridBagConstraints.gridx = 1;
        container.add(formularioArea, gridBagConstraints);

        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridx = 0;

        etiquetaPerimetro = new JLabel("Perimetro : ");
        container.add(etiquetaPerimetro, gridBagConstraints);
        formularioPerimetro = new JTextField(5);
        formularioPerimetro.setEditable(false);

        gridBagConstraints.gridx = 1;
        container.add(formularioPerimetro, gridBagConstraints);

        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER; // Ocupa todas las celdas restantes
        botonCerrar = new JButton("Cerrar");
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL; // Para que el botón ocupe todo el ancho disponible
        container.add(botonCerrar, gridBagConstraints);

        formularioRadio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double radio = Double.parseDouble(formularioRadio.getText());
                double area, perimetro;

                area = Math.PI * Math.pow(radio, 2);
                String areaFormateada = String.format("%.1f", area);
                perimetro = 2 * (Math.PI) * radio;
                String perimetroFormateado = String.format("%.1f", perimetro);
                formularioArea.setText(areaFormateada);
                formularioPerimetro.setText(perimetroFormateado);

            }

        });
        botonCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                formularioRadio.setText("");
                formularioArea.setText("");
                formularioPerimetro.setText("");
                formularioRadio.requestFocus();
            }
            
        });

    }

}
