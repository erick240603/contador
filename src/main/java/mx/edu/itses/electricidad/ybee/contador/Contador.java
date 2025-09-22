package mx.edu.itses.electricidad.ybee.contador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Contador {

    private int contador = 0;

    private JLabel labelContador;
    private JButton botonMas;
    private JButton botonMenos;
    private JButton botonReset;

    public Contador() {
        JFrame frame = new JFrame("Contador");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150); 
        frame.setLocationRelativeTo(null); 
        
        JPanel panelPrincipal = new JPanel(new BorderLayout());

        labelContador = new JLabel(String.valueOf(contador), SwingConstants.CENTER);
        labelContador.setFont(new Font("Arial", Font.BOLD, 48)); 
        labelContador.setForeground(new Color(50, 50, 50)); 

        JPanel panelBotones = new JPanel(new GridLayout(1, 3, 10, 0)); 

        botonMenos = new JButton("-");
        botonReset = new JButton("Reset");
        botonMas = new JButton("+");

        panelBotones.add(botonMenos);
        panelBotones.add(botonReset);
        panelBotones.add(botonMas);

        panelPrincipal.add(labelContador, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        frame.add(panelPrincipal);


        botonMas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contador++;
                actualizarContador();
            }
        });

        botonMenos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contador--;
                actualizarContador();
            }
        });

        botonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contador = 0;
                actualizarContador();
            }
        });

        frame.setVisible(true);
    }

    private void actualizarContador() {
        labelContador.setText(String.valueOf(contador));
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Contador();
            }
        });
    }
}