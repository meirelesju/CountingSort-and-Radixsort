
import java.io.*; 
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Julianny Meireles
 */
 
  
class RadixSort extends CountingSort{ 
  
    static void RadixSort(int A[]) 
    { 
        CountingSort counting = new CountingSort();
        int comprimento = A.length;
        // Encontra o menor valor de A
        int min = min(A); 
  
        //inicializa no 1 pois é a primeira casa decimal a ser "analizada"
        //a quanidade de iterações varia de acordo com a quantidade de casas que o número max do array de entrada possui
        for (int i = 1; min/i > 0; i *= 10) 
            System.out.println("i ="+i);
            Ordena(A);
        
        //printar
        for(int j = 0; j<comprimento;j++)
            System.out.println(A[j]);
    } 
  
   
  
    //Ler o arquivo e armazenar os valores
    static  ArrayList<Integer> lista = new ArrayList<>();
        
        static ArrayList<Integer> arquivo(String arq) throws FileNotFoundException {

            Scanner ler = null;
           ler = new Scanner(new File(arq));
           while (ler.hasNext()) {
               lista.add(ler.nextInt());
           }
           ler.close();
           return lista;
       }
  
   
    public static void main (String[] args) throws FileNotFoundException 
    { 
        arquivo("src/num.1000.1.in");
        
        int A[] = new int [lista.size()];
           for(int i = 0; i<lista.size();i++){
               A[i]=lista.get(i);
           } 
        
        RadixSort(A); 
         
    } 
} 
