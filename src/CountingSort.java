
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Julianny Meireles
 */
public class CountingSort {
   
    
    
     //Minimo
   static int min(int []A){    
    
    int comprimento = A.length;
    int min = A[0]; //pega o primeiro elemento de A pra comparar
        for (int i = 1; i < comprimento; i++) { //inicializa em 1 pois o max já tem o primeiro elemento a ser comparado
         
            if (A[i] < min) //se A[i] for maior que o min, ele passa a ser o max
           min = A[i];
        }
        return min;
       
}
   
   static int max(int [] A){
        //Maximo
         int max = A[0]; //pega o primeiro elemento de A pra comparar
            for (int i = 1; i < A.length; i++) { //inicializa em 1 pois o max já tem o primeiro elemento a ser comparado
             if (A[i] > max) //se A[i] for maior que o max, ele passa a ser o max
                     max = A[i];
            }
            return max;
   }
    
    
    
    
    
    public static void Ordena(int[] A, int decimal){
        
        int comprimento  = A.length;
        int intervalo = max(A) - min(A) + 1; 
        int vetorAux[] = new int[intervalo]; 
        int vetorOrd[] = new int[A.length]; 
        
         //1ª parte: Seta todo vetor auxiliar para zero
            for(int i = 0; i < comprimento; i++){
                vetorAux[i] = 0;
            }
        
        //2ª parte: Conta as frequências dos elementos do array principal e coloca no array auxiliar
        for(int j = 0; j < comprimento; ++j){  
   
            //"retorna" o elem mais a direita como o radix pede
            int elem_mais_a_direita = ((A[j]/decimal)%10);
            
            /*perceba que o elem_mais_a_esquerda está subtraindo com o valor mínimo pois agora que também existem
             números negativos no array,
             ele "empurra" as frequências de números positivos para a frente (quantidade de casas equivalente ao numero minimo)  
            */
            vetorAux[ elem_mais_a_direita - min(A)] = vetorAux[elem_mais_a_direita - min(A)] + 1 ;  
            
            
        } 
        
        
        //3ª parte: Ordena o array auxiliar (que atualmente se encontra apenas com as frequências)
        for (int i = 1; i < intervalo; i++){   
           
           //a partir do índice 1, soma o elemento posterior com o anterior e e coloca no índice correspondente       
            vetorAux[i] = vetorAux[i] + vetorAux[i-1];
            
        } 
          
        
         //4ª parte: Ordena
        for (int j = comprimento - 1; j >= 0; j--){   
        
            
            int elem_mais_a_direita = ((A[j]/decimal)%10);
            
            vetorOrd[vetorAux[elem_mais_a_direita - min(A)] - 1] = A[j]; //pega os elementos de A e coloca em vetorOrdenado(de trás pra frente)
            vetorAux[elem_mais_a_direita - min(A)] = vetorAux[elem_mais_a_direita - min(A)] - 1; //decrementa a posição que foi usada do vetorAux   
        
        } 
  
        //5ª parte: Armazena o vetor ordenado no vetor original
            for (int i = 0; i < comprimento; i++)
                A[i]= vetorOrd[i];
                    
             
        //6ª parte: Printa
            
          // for(int juju = 0; juju<comprimento;juju++)
          //System.out.println(A[juju]);
        
    } 
}
