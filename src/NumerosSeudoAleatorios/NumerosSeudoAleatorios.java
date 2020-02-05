/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NumerosSeudoAleatorios;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author dzp
 */
public final class NumerosSeudoAleatorios {
    Scanner teclado;
    IO io;
    Metodos metodos;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        new NumerosSeudoAleatorios();
    }
    
    public NumerosSeudoAleatorios() throws IOException
    {
        teclado = new Scanner(System.in);
        metodos = new Metodos();
        String entrada;
        
        io = new IO("archivo.bin");
        
        do{
            System.out.print("\n1. Generar Numerso seudoaleatorios cuadrados centrales(Von Neumann)\n");
            System.out.print("2. Ver numeros del archivo\n");
            System.out.print("3. Eliminar numeros del archivo\n");
            System.out.print("4. Salir\n");
            System.out.print("OPCION: ");
            
            entrada = teclado.nextLine();
            
            switch(entrada){
                case "1": generarNumerosCuadradosCentrales(); break;
                case "2": mostrarArchivo(); break;
                case "3": vaciarArchivo(); break;
                case "4": System.out.println("Saliendo..."); break;
            }
            
        }while(!entrada.equals("4"));
        
        io.cerrar_archivo();
    }
    
    public void generarNumerosCuadradosCentrales() throws IOException{
        int semilla;
        int nDigitos;
        int noVariables;
        
        float seudoNumeros[];
        String cadena;
        boolean esNumero;
        
        do{
            System.out.print("Introduce cemilla: ");
            cadena = teclado.nextLine();
            semilla = Integer.parseInt(cadena);
        }while(semilla < 1000);
        System.out.print("Introduce los digitos a tomar del centro: ");
        cadena = teclado.nextLine();
        nDigitos = Integer.parseInt(cadena);
        System.out.print("Introduce el numero de variables a generar: ");
        cadena = teclado.nextLine();
        noVariables = Integer.parseInt(cadena);
        
        System.out.println("---- Catidad: "+noVariables+", Semilla: "+semilla+" ----");
        
        seudoNumeros = metodos.cuadrados_centrales(semilla, nDigitos, noVariables);
        
        io.escribir_flotantes(seudoNumeros);
    }
    
    void mostrarArchivo() throws IOException{
        float seudoNumeros[];
        
        seudoNumeros = io.leer_flotantes();
        
        if(seudoNumeros != null)
        {
            System.out.println("---- Numeros en el archivo ----------");
            for(int i=0;i<seudoNumeros.length;i++)
                System.out.println((i+1)+". "+seudoNumeros[i]);
        }
        else
            System.out.println("El archivo esta vacio");
    }
    
    void vaciarArchivo() throws IOException{
        if(!io.vaciarArchivo())
            System.out.println("Archivo vaciado");
    }
}
