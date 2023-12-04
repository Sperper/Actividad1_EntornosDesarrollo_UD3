/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actividad_01_UD3_ED;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author ana
 */
public class Actividad_01_UD3_ED_Refactorizado 
        
/**
 * 
 * @author Samuel - Traduce variables al español - 04/12/2023 09:32
 */

{
    private static byte[] intermedio = new byte[1000];
    private static String nombreDeArchivo = "fichero.dat";
    private static FileInputStream entradaDeFlujo = null;
    private static BufferedInputStream entradaDeIntermedio = null;

    public static void InicializarArchivos() throws FileNotFoundException
    {
        entradaDeFlujo = new FileInputStream(nombreDeArchivo);
        entradaDeIntermedio = new BufferedInputStream(entradaDeFlujo);
    }
    
    public static int MostrarArchivoDeTexto() throws IOException
    {
        int total = 0;
        int nLeer = 0;
        while((nLeer = entradaDeFlujo.read(intermedio)) != -1) 
        {
            System.out.println(new String(intermedio));
            total += nLeer;
        }
        
        return total;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {        
        try 
        {
            InicializarArchivos();
            
            int total = MostrarArchivoDeTexto();           

            System.out.println("\nLeídos " + total + " bytes");
        }
        catch(IOException ex) 
        {
            System.out.println("Error -> " + ex.toString());                
        }
        finally 
        {
            try 
            {
                if( entradaDeIntermedio != null && entradaDeFlujo != null )
                {
                    entradaDeFlujo.close();
                    entradaDeIntermedio.close();
                }                
            } 
            catch (IOException ex) 
            {
                System.out.println("Error al cerrar el fichero -> " + ex.toString());
            }
        }
    }
    
}
