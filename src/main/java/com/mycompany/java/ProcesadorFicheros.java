
package com.mycompany.java;
// Dado un fichero de entrada y una letra
// contamos cuantas veces aparece dicha letra
// y dejamos el recuento en un fichero de salida

import java.io.*;
import static java.lang.System.exit;
import java.util.ArrayList;

public class ProcesadorFicheros{

 public static void main(String[] args) throws IOException {
        //nombre del fichero a procesar(posición 0), letra que debe buscar (posición 1), nombre del fichero en que dejará los resultados 
        String nombreFicheroEntrada;
        String letra;
        String nombreFicheroResultados;
        //int contador = 0;
        
        if( args.length < 3 | args.length >3 ){
            System.out.println("Cantidad de parámetros incorrecta");
            exit(-1);
        }
        
        nombreFicheroEntrada = args[0];
        letra = args[1].toLowerCase();
        nombreFicheroResultados = args[2];
        
        ArrayList<String> lineas = UtilidadesFicheros.getLineasFichero(nombreFicheroEntrada);
        
        int contador = cuentaLetras(lineas, letra);
        
        PrintWriter pw = UtilidadesFicheros.getPrintWriter(nombreFicheroResultados);
        
        pw.print("" + contador);
        pw.flush();
        pw.close();
    }
    
    private static int cuentaLetras(ArrayList<String> lineas, String letra){
        int contador = 0;
        for (String linea : lineas) {
            linea = linea.toLowerCase();
            for(int i = 0; i<linea.length(); i++){
                if( letra.charAt(0) == linea.charAt(i)){
                    contador = contador + 1;
                }
            }
        }
        return contador;
    }
    
}
