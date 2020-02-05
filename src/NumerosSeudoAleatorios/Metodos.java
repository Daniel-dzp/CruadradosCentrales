/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NumerosSeudoAleatorios;

/**
 * @author dzp
 */
public class Metodos {
    public float[] cuadrados_centrales(int semilla, int nDigitos, int noVariables)
    {
        long cuadrado;
        String cuadradoCadena;
        float seudoNumeros[];
        float seudoNumero;
        String seudoNumeroCadena;
        int digitos;
        int cerosAgregar=0;
        int mediaCuadrado, mediaNDigitos;
        
        seudoNumeros = new float[noVariables];
        for(int i=0;i<noVariables;i++)
        {
            cerosAgregar=0;
            cuadrado = semilla*semilla;
            cuadradoCadena = String.valueOf(cuadrado);
            
            if(cuadradoCadena.length() < nDigitos)
            {
                cerosAgregar = cuadradoCadena.length()-nDigitos;
            }
            
            if(cuadradoCadena.length()%2!=0 && nDigitos%2==0)
                cerosAgregar = 1;
            
            if(cuadradoCadena.length()%2==0 && nDigitos%2!=0)
                cerosAgregar = 1;
            
            for(int j=0;j<cerosAgregar;j++)
                cuadradoCadena = "0"+ cuadradoCadena;
            
            mediaCuadrado = cuadradoCadena.length() / 2;
            mediaNDigitos = nDigitos / 2;
            
            seudoNumeroCadena = cuadradoCadena.substring(mediaCuadrado-mediaNDigitos, mediaCuadrado-mediaNDigitos+nDigitos);
            seudoNumero = Float.parseFloat("0."+seudoNumeroCadena);
            
            System.out.println((i+1) + ". ("+semilla+")^2="+cuadradoCadena+" Centrales="+seudoNumeroCadena+" Seudonumero="+seudoNumero);
            //System.out.println("Semilla: "+semilla+" - Cuadrado: "+cuadradoCadena+" - SeudoNumero: "+seudoNumero);
            
            semilla = Integer.parseInt(seudoNumeroCadena);
            seudoNumeros[i] = seudoNumero;
        }
        
        return seudoNumeros;
    }
}
