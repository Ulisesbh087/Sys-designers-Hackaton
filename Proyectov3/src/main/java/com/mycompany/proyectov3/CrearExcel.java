/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectov3;

import java.util.ArrayList;


import ejemploapachepoi.EjemploApachePOI;

public class CrearExcel {
    private EjemploApachePOI excel;

    public void EscribirEXCEL(ArrayList lista, String nombreArchivo) {
        excel.EscribirEXCEL();
        //excel.EscribirEXCELLista(lista, nombreArchivo);
        /*
        String hoja = "Datos";

        XSSFWorkbook libro = new XSSFWorkbook();
        XSSFSheet hoja1 = libro.createSheet(hoja);

        // Cabecera de la hoja de excel
        String[] header = new String[]{"C°", "F°", "FECHA", "HORA", "LOCALIZACION", "", "NOMBRE DE LA IMAGEN", "RUTA DE ACCESO A LA CARPETA", "TAMAÑO"};

        // Contenido de la hoja de excel (ingreso de metadatos)
        String[][] document = new String[][]{
            {"24", "75°", "10/06/2020", "10:12:45", "0006", "0011", "jaguar-png", "C:/Users/rayos/Documentos/jaguar.png", "58.5KB"} //EJEMPLO DE LOS DATOS QUE SE MUESTRAN EN EXCEL         
        };

        // Poner en negrita la cabecera
        CellStyle style = libro.createCellStyle();
        Font font = libro.createFont();
        font.setBold(true);
        style.setFont(font);

        
        // Generar los datos para el documento
        for (int i = 0; i < lista.size(); i++) {
            XSSFRow row = hoja1.createRow(i); // Se crea la fila
            ArrayList listaMeta=(ArrayList) lista.get(i);
            for (int j = 0; j < listaMeta.size(); j++) {
                    XSSFCell cell = row.createCell(j); // Se crean las celdas para el contenido
                    cell.setCellValue(listaMeta.get(j).toString()); // Se añade el contenido
            }
        }
/*
        // Generar los datos para el documento
        for (int i = 0; i <= document.length; i++) {
            XSSFRow row = hoja1.createRow(i); // Se crea la fila
            for (int j = 0; j < header.length; j++) {
                if (i == 0) { // Para la cabecera
                    XSSFCell cell = row.createCell(j); // Se crean las celdas pra la cabecera
                    cell.setCellValue(header[j]); // Se añade el contenido 
                } else {
                    XSSFCell cell = row.createCell(j); // Se crean las celdas para el contenido
                    cell.setCellValue(document[i - 1][j]); // Se añade el contenido
                }
            }
        }
        
        // Crear el archivo
        try (OutputStream fileOut = new FileOutputStream(nombreArchivo)) {
            System.out.println("SE CREO ARCHIVO EXCEL");
            libro.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
