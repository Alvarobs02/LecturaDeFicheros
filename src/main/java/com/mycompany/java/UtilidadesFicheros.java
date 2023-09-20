
package com.mycompany.java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class UtilidadesFicheros {

    
    public static BufferedReader getBufferedReader(String nombreDeFichero) throws FileNotFoundException {
        BufferedReader br;
        
        FileReader fr = new FileReader(nombreDeFichero);
        br = new BufferedReader(fr);
        return br;
    }
    
    public static PrintWriter getPrintWriter( String nombreFichero) throws IOException {
        PrintWriter pw;
        FileWriter fw = new FileWriter(nombreFichero);
        pw = new PrintWriter(fw);
        return pw;
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
            
}

