
package com.mycompany.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lanzador {

public static void main(String[] args) throws FileNotFoundException, IOException {

    String nombreFicheroEntrada = args[0];
    String nombreFicheroResultado = args[2];
    String rutaProcesador = "C:\\Users\\CES\\Documents\\NetBeansProjects\\6979.java\\target\\6979.java-1.0-SNAPSHOT.jar";
    String directorioSalida = "C:\\Users\\CES\\Downloads\\";
    
    if( args.length !=3 ){
            System.out.println("Cantidad de parámetros incorrecta");
            exit(-1);
        }
     String[] letras = {"M", "N", "R", "P"};
     for( int i = 0; i < 4; i++ ){
            
            String ficheroErrores = "Errores_" + letras[i] + ".txt";
            String ficheroSalida = "ficheroLetra" + letras[i] + ".txt";

            ProcessBuilder pb;
            pb = new ProcessBuilder("java", "-cp", rutaProcesador, "com.mycompany.java.ProcesadorFicheros", nombreFicheroEntrada, letras[i], ficheroSalida );
            pb.directory(new File(directorioSalida));
            
            pb.redirectError(new File(ficheroErrores));
            
            try {
                pb.start();
            } catch (IOException ex) {
                Logger.getLogger(Lanzador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } //fin del for
        
        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Lanzador.class.getName()).log(Level.SEVERE, null, ex);
        }
        // ya hemos contado las letras
   
        
             imprimirResultados(letras, directorioSalida);
             System.out.println("Adios!");
    }

private static void imprimirResultados(String[] letras, String directorioSalida){
        
        String ficheroEntrada;
        try {
            for(int i=0; i < 4; i++){

                ficheroEntrada =  directorioSalida + "ficheroLetra" + letras[i] + ".txt";

                ArrayList<String> lineas;
                lineas = getLineasFichero(ficheroEntrada);
                String linea = lineas.get(0);
                System.out.println("La letra " + letras[i] + " tiene " + linea + " apariciones");
            }
        } catch (IOException ex) {
                Logger.getLogger(Lanzador.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public static ArrayList<String> getLineasFichero( String nombreFichero) throws IOException {
        ArrayList<String> arLineas = new ArrayList<>();

        BufferedReader br = getBufferedReader(nombreFichero);

        String linea = br.readLine();
        while( linea != null ) {
            arLineas.add(linea);
            linea = br.readLine();
        }

        return arLineas;        
    }
    
    public static BufferedReader getBufferedReader(String nombreDeFichero) throws FileNotFoundException {
        BufferedReader br;
        
        FileReader fr = new FileReader(nombreDeFichero);
        br = new BufferedReader(fr);
        return br;
    }

}