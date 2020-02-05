/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NumerosSeudoAleatorios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

/**
 *
 * @author dzp
 */
public class IO {
    RandomAccessFile file;
    private String nombre;
    
    public IO(String archivo)
    {
        nombre = archivo;
        try{
            file = new RandomAccessFile(archivo,"rw");
            
        }catch(FileNotFoundException e)
        {
            System.out.println("Error al abrir archivo");
        }
    }
        
    public float[] leer_flotantes() throws IOException{
        long longitud;
        int noFlotantes;
        float flotantes[] = null;
        
        file.seek(0);
        longitud = file.length();
        
        if(longitud != 0)
        {
            noFlotantes = (int) (longitud/4);

            flotantes = new float[noFlotantes];
            for(int i=0;i<noFlotantes;i++)
            {
                flotantes[i] = file.readFloat();
            }
        }
        
        return flotantes;
    }
    
    public void escribir_flotantes(float numeros[]) throws IOException{
        long longitud;
        
        longitud = file.length();
        file.seek(longitud);
        
        for(int i=0;i<numeros.length;i++)
            file.writeFloat(numeros[i]);
    }
    
    public boolean vaciarArchivo() throws IOException{
        file.close();
        
        try
        {
            FileWriter archivo = new FileWriter(nombre, false);
            PrintWriter escribir = new PrintWriter(archivo);
            escribir.close();
            
            file = new RandomAccessFile(nombre,"rw");
            
            return false;
        }catch(FileNotFoundException e){
            System.out.println("Error al vaciar archivo");
            
            return true;
        }
        
    }
    
    public void cerrar_archivo() throws IOException
    {
        file.close();
    }
}
