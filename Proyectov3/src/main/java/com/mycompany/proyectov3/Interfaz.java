/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectov3;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

public class Interfaz {

    static JTextField texto;
    //static JTextArea textArea;
    private JPanel contentPane;

    JFileChooser chooser;
    String choosertitle;

    Interfaz() {
        String rutaProyecto = new File(".").getAbsolutePath();//Se obtiene la ruta del proyecto
        String separador = System.getProperty("file.separator"); //Se obtiene el separador de ruta

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 921, 532);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(255, 69, 0), 2, true));
        panel.setBackground(new Color(255, 140, 0));
        panel.setBounds(0, 0, 905, 493);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lbljaguar = new JLabel("New label");
        lbljaguar.setBounds(565, 37, 330, 445);
        lbljaguar.setIcon(new ImageIcon((rutaProyecto + separador + "Imagenes" + separador + "jaguar.png")));
        panel.add(lbljaguar);

        JLabel lblNewLabel = new JLabel("Systems Design.");
        lblNewLabel.setFont(new Font("Serif", Font.BOLD, 83));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(71, 11, 587, 114);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Animal Karma.");
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("Segoe Script", Font.PLAIN, 50));
        lblNewLabel_1.setBounds(133, 89, 446, 121);
        panel.add(lblNewLabel_1);

        JButton btnNewButton = new JButton("Seleccionar");
        btnNewButton.setBorder(new LineBorder(new Color(255, 69, 0)));
        btnNewButton.setFont(new Font("Serif", Font.PLAIN, 30));
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setBackground(new Color(255, 69, 0));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                chooser = new JFileChooser();
                chooser.setCurrentDirectory(new java.io.File("."));
                chooser.setDialogTitle(choosertitle);
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                //
                // disable the "All files" option.
                //
                chooser.setAcceptAllFileFilterUsed(false);
                //    
                if (chooser.showOpenDialog(contentPane) == JFileChooser.APPROVE_OPTION) {
                    System.out.println("getCurrentDirectory(): "
                            + chooser.getCurrentDirectory());
                    System.out.println("getSelectedFile() : "
                            + chooser.getSelectedFile());
                    texto.setText(chooser.getSelectedFile().toString());
                } else {
                    System.out.println("No Selection ");
                }
            }

        });
        btnNewButton.setBounds(44, 392, 180, 42);
        panel.add(btnNewButton);

        JButton btnNewButton2 = new JButton("Procesar");
        btnNewButton2.setBorder(new LineBorder(new Color(255, 69, 0)));
        btnNewButton2.setFont(new Font("Serif", Font.PLAIN, 30));
        btnNewButton2.setForeground(Color.WHITE);
        btnNewButton2.setBackground(new Color(255, 69, 0));
        btnNewButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (texto.getText() != null || texto.getText()!="") {
                    Clasificacion clasificacion = new Clasificacion();
                    clasificacion.Principal(texto.getText());
                }else{
                    JOptionPane.showMessageDialog(frame, "Debes selccionar una carpeta");
                }
            }

        });
        btnNewButton2.setBounds(600, 392, 180, 42);
        panel.add(btnNewButton2);

        texto = new JTextField();
        texto.setBounds(235, 400, 320, 34);
        panel.add(texto);
        texto.setColumns(10);
        frame.add(panel);
        frame.setVisible(true);
        //textArea = new JTextArea();
        //textArea.setBounds(160, 320, 380, 58);
        //panel.add(textArea);
    }
}
