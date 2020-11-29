/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectov3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Clasificacion {

    public void Principal(String direccion) {
        System.out.println(direccion);
        Scanner teclado = new Scanner(System.in);
        String separador = System.getProperty("file.separator"); //Se obtiene el separador de ruta
        String direccionXML = "";
        String rutaProyecto = new File(".").getAbsolutePath();//Se obtiene la ruta del proyecto
        direccionXML = rutaProyecto + separador+"xml";
        System.out.println("Dirección?");
        //final String direccion = teclado.nextLine();
        Procesamiento procesamiento = new Procesamiento();

        try {
            Files.walk(Paths.get(direccionXML)).forEach(ruta -> { //Se lista el directorio ingresado
                if (Files.isRegularFile(ruta)) {
                    //Se valida que sea una ruta válida
                    try {
                        File archivo = ruta.toFile();//Se convierte la ruta a tipo archivo
                        procesamiento.Principal(direccion, archivo.getName());
                        System.out.println("XML: "+archivo.getName());
                    } catch (IOException ex) {
                        Logger.getLogger(Clasificacion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            JOptionPane.showMessageDialog(null, "Proceso terminado");
        } catch (IOException ex) {
            Logger.getLogger(Clasificacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
