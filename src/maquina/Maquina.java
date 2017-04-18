package maquina;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author luzballestame
 */
public class Maquina {
    private static  String[] Reglas = new String[20];
    
    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File Ffichero=new File("/home/dehiler/cr.txt");
        LeerFichero(Ffichero,Reglas);
    }
    //funcion para leer Fichero...
     static  void LeerFichero(File Ffichero, String[] Reglas){
         int con = 0;
   try {
       
       //Si existe el fichero
       if(Ffichero.exists()){
           //Abre un flujo de lectura a el fichero
           BufferedReader Flee= new BufferedReader(new FileReader(Ffichero));
           String Slinea;
           System.out.println("**********Leyendo Fichero***********");
           //Lee el fichero line a linea hasta llegar a la ultima
         
           while((Slinea=Flee.readLine())!=null) {
           //Imprime la linea leida
           Reglas[con] = Slinea;
           
           System.out.println(Reglas[con]);
           con = con +1;
           }
           System.out.println("*********Fin Leer Fichero**********");
           //Cierra el flujo
           Flee.close();
         }else{
           System.out.println("Fichero No Existe");
         }
   } catch (Exception ex) {
       //Captura un posible error y le imprime en pantalla
        System.out.println(ex.getMessage());
   }
 //netrada del testo  Ei,SL,Ef,SE,M
     String convertir = "ababb";
     char[] Cadena = convertir.toCharArray();
     char estadoActual = '1';
    
     int con2 = 0;
     int tam = convertir.length();
     int sw = 0;
     int contador;
     int vez;
     char estadoIregla;
     
         //con-1 es el numero de reglas que hay
         
     while(con2 < tam && sw==0){
     
         vez = 0;
         contador = 0;
         //mientras que para buscar la regla que sirve la primera vez...
         while(contador < con-1 && vez == 0){
             char[] Analizar = Reglas[contador].toCharArray();
             estadoIregla = Analizar[0];
             char carAleer= Analizar[4]; 
             System.out.println("Estado actual:"+estadoActual);
             System.out.println("Estado Regla:"+estadoIregla);
             System.out.println("Caracter que lee:"+carAleer);
             System.out.println("Cararcter que Verifica "+Cadena[con2]);
              if(estadoActual == estadoIregla && carAleer == Cadena[con2]){
                   System.out.println("Reemplaza a: "+ Cadena[con2] +" por "+ Analizar[6]); 
                   Cadena[con2] = Analizar[6];
                    estadoActual = Analizar[2];
                    
                    
                    System.out.println("**************************");
                    vez=1;
                    }else{contador = contador +1;
              System.out.println("No Cumple la condicion.....");}
              System.out.println("**************************");
                
                 
         }//fin del mientras que
         
     con2 = con2 +1;
     }//fin del mientras que...
    
         System.out.println("Cadena resultante: ");
         System.out.println(Cadena);
                 
      
 }
    
 
}