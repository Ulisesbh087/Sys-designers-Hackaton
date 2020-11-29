/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectov3;

//import static com.mycompany.proyectov3.NewMain.copiarImagen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.objdetect.CascadeClassifier;

/**
 *
 * @author system designers
 */
public class Procesamiento {

    public void CrearDirectorio(File directorio) {
        if (!directorio.exists()) { //Se verifica que el directorio no exista
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }
    }

    public void copiarImagen(File archivo, Path ruta, String separador, String rutaProyecto, String carpeta) {
        File origen = archivo; //Seleccionamos el archivo origen
        File destino = new File(rutaProyecto + separador + carpeta + separador + ruta.getFileName().toString());//Se toda la ruta del proyecto para copiar la imagen
        //System.out.println("Destino: "+ destino.getPath());
        try {
            InputStream in = new FileInputStream(origen); //Se crea in archivo de entrada
            OutputStream out = new FileOutputStream(destino); //Se crea un archivo de salida

            byte[] buf = new byte[1024];
            int len;

            while ((len = in.read(buf)) > 0) {//Se copia la imagen de una ruta a otra para poder trabajar
                out.write(buf, 0, len);
            }
            in.close();//Se cierran los archivos utilizados para la copia
            out.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void Principal(String direccion, String archivoXML) throws IOException {
        ArrayList lista = new ArrayList();

        String rutaProyecto = new File(".").getAbsolutePath();//Se obtiene la ruta del proyecto
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);//Seinicia la librería openCV       

        String so = System.getProperty("os.name"); //Se obtiene el SO
        String separador = System.getProperty("file.separator"); //Se obtiene el separador de ruta        

        File dir = new File(direccion);
        String carpetaFiltro = dir.getName() + " (Filtrado)"+archivoXML.substring(0, archivoXML.length()-4);

        dir = new File(dir.getParent());

        File directorioFiltro = new File(dir + separador + carpetaFiltro + separador);//Se crea el directorio para que se guarden las imagenes filtradas
        CrearDirectorio(directorioFiltro);

        String rutaFinal = dir + separador;
        Files.walk(Paths.get(direccion)).forEach(ruta -> { //Se lista el directorio ingresado

            if (Files.isRegularFile(ruta)) { //Se valida que sea una ruta válida
                File archivoMeta = ruta.toFile();  
                File archivo = ruta.toFile();//Se convierte la ruta a tipo archivo
                Path path = Paths.get(archivo.getPath());  //Se obtiene la ruta del archivo
                
                try {

                    String tipo = Files.probeContentType(path);//Se obtiene el tipo de archivo
                    //System.out.println(tipo);

                    if (tipo.equalsIgnoreCase("image/jpeg") || tipo.equalsIgnoreCase("image/png")) {//Se filtran los archivos que sean imagenes

                        copiarImagen(archivo, ruta, separador, rutaProyecto, "images");//copiar imagen al directorio de trabajo
                        String imgFile = rutaProyecto + separador + "images" + separador + ruta.getFileName().toString();//Se obtiene la ruta especifica de la imagen

                        Mat src = Imgcodecs.imread(imgFile); //Se convierte la imagen en matriz para su análisis

                        //String xmlFile = "xml/lbpcascade_frontalface.xml";//Se toma el xml entrenado para el reconociemiento
                        String xmlFile = "xml/" + archivoXML;//Se toma el xml entrenado para el reconociemiento
                        CascadeClassifier cc = new CascadeClassifier(xmlFile);//Se crea la variable de Cascada apartir de xml

                        MatOfRect faceDetection = new MatOfRect();//Variable de deteccción
                        cc.detectMultiScale(src, faceDetection);//Se lleva a acabo la detección
                        System.out.println(String.format("Detected faces: %d", faceDetection.toArray().length));

                        if (faceDetection.toArray().length > 0) {//Se compara si se encontró el objeto deseado en la imagen           

                            File aux = path.toFile(); //Se crea una variable File a partir de la variable path
                            aux = new File(aux.getParent());//Se usa aux para aceder a la carpeta padre de la dirección que ingresó el usuario
                            path = Paths.get(aux.getPath() + separador + ruta.getFileName().toString()); //La variable path se sustituye con la nueva ruta
                            copiarImagen(new File(imgFile), path, separador, rutaFinal, carpetaFiltro);//Se realiza la copia de la imagen filtrada

                            //new File(imgFile).delete();
                            archivo.delete();
                        }
                        System.out.println("Image Detection Finished");

                    }
                } catch (IOException ex) {
                    Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }
}
