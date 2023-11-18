/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab6p1_hannemendoza;
import java.util.Scanner;
import java.util.Random;
public class Lab6P1_HanneMendoza {

    static Scanner kore = new Scanner (System.in);
    static Random rand  = new Random();
    public static void main(String[] args) {
        System.out.println("********MENU********");
        System.out.println("1. Conjuntos ");
        System.out.println("2. ¿Cuántos primos tienes?");
        System.out.println("Ingrese la opción: ");
        int opcion = kore.nextInt();
        
        while(opcion > 0 && opcion<3){
            
            switch(opcion){
              
                case 1:
                    System.out.println("Size SET1:  ");
                    int size1 = kore.nextInt();
                    char SET1 [] = new char [size1];
                    System.out.println("Size SET2: ");
                    int size2 = kore.nextInt();
                    char SET2 [] = new char[size2];
                    
                    SET1 = genRandCharArray(size1);
                    SET2 = genRandCharArray(size2);
                    
                    System.out.println("Conjuntos generados: ");
                    System.out.print("\nSET 1: ");
                    imprimir(SET1);
                    System.out.print("\nSET 2: ");
                    imprimir(SET2);
                    System.out.println("");
                    
                    System.out.println("\nOperaciones");
                    System.out.println("1. Intersección");
                    System.out.println("2. Diferencia");                    
                    int opcion2 = kore.nextInt();
                    
                    switch(opcion2){
                        case 1:
                            System.out.print("Intersección(SET1,SET2): ");
                            //intersection(SET2, SET2);
                            imprimir(intersection(SET1, SET2));
                            break;
                        case 2:
                            System.out.print("Diferenica (SET1,SET2): ");
                            //imprimir(diferencia);
                            break;
                    }
                    
                    
                    
                    break;
                     
                case 2: 
                    
                    System.out.println("Ingese el tamaño del arreglo a generar: ");
                    int tam = kore.nextInt();                   
                    System.out.println("Ingrese el límite inferior: ");
                    int linf = kore.nextInt();
                    System.out.println("Ingrese su límite superior");
                    int lsup = kore.nextInt();
                    
                    int [] listaRandom = new int[tam];
                    listaRandom = genRandArray(tam,linf,lsup);
                    int[] listaDivPrim = new int[tam];
                    listaDivPrim =getTotalPrimeCount(listaRandom);
        
                    System.out.print("Arreglo generado: ");
                    imprimir(listaRandom);                    
                    System.out.print("\nNo. divisores primos: ");
                    imprimir(listaDivPrim);
                    
                    break;
                
                
                
            }//switch
            
        System.out.println("\n********MENU********");
        System.out.println("1. Conjuntos ");
        System.out.println("2. ¿Cuántos primos tienes?");
        System.out.println("Ingrese la opción: ");
        opcion = kore.nextInt();
            
        }//while
    }//metodo
    
    public static char [] genRandCharArray(int size){
        char temp []  = new char[size];
        
        for(int i = 0; i<size ; i++){
            
          int num = rand.nextInt(8)+65;  
          char carac = (char)num;
          temp [i] = carac; 
        }
        return temp;
    }
    
    public static char [] intersection(char [] array , char [] array2){      
         int acum = 0;
         char arreglo_interseccion [] = new char [array.length];
          if (array.length > array2.length) {
               arreglo_interseccion = new char[array.length];
          }else{
               arreglo_interseccion = new char[array2.length];
          }
        
        
        if (array.length > array2.length) {
                for(int i = 0; i < array2.length-1 ; i++ ){
                    for(int j = 0; j < array.length; j++){
                        if(array2[i] == array[j]){
                            
                        }
                    }   
                }        
       
        }/*else{
            for(int i = 0; i < array.length-1 ; i++ ){
                for(int j = 0; j < array2.length; j++){
                    if(array[i] == array2[j]){
                        acum += array[i];
                        arreglo_interseccion[i] = acum;
                    }
                }        
            
            }
         
        }*/
        return arreglo_interseccion;
    }
    
    public static void imprimir(char[] arreglo) {
        for (int j = 0; j < arreglo.length; j++) {
            System.out.print( "[ " + arreglo[j] + " ]");           
        }     
    }
    
    //case 2
    
    public static int[] genRandArray(int ptam, int plinf, int plsup) {
        Random rand = new Random();
	int[] lRandom;
	lRandom = new int[ptam];
	        
	    for (int i = 0; i < ptam; i++) {       
                int x = plinf + rand.nextInt(plsup);
	        lRandom[i] = x;
	        }
	    return lRandom;
	    }//fin del método genRandArray
    
    public static void imprimir(int[] arreglo) {
	        for (int j = 0; j < arreglo.length; j++) {
	            System.out.print("[" + arreglo[j] + "]");	          
	        }
	    }//fin del método imprimir
	 
    public static boolean isPrime(int n) {
        boolean primo = true;
        int m = n/2;   

        if((n==0) || (n==1)){  
            primo = false;
        }else{  
            for(int i=2; i<=m; i++){      
                if(n%i==0){      
                    primo = false;    
                }      
            }
        }  

        return primo;
     }//fin del método isPrime


    public static int countPrimeFactors(int num) {
            int acum=0;
            for(int k=1; k<=num; k++){
                if(num%k==0){
                    System.out.println(k + " divisor");
                    if (isPrime(k)) {
                        System.out.println(k + " es primo");
                        acum++;
                    }//fin if primos 

                }//fin if divisores

            }//fin for
        return acum;
    }//fin del método countPrimeFactors

    public static int [] getTotalPrimeCount(int [] lista) {
        int[] cuentaPrimos = new int[lista.length];
        for(int k=0; k<lista.length; k++){
            cuentaPrimos[k] = countPrimeFactors(lista[k]);
        }
        return cuentaPrimos;
    } //fin del método getTotalPrimeCount



}//clase