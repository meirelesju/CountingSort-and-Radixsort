
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
   
    public static void Ordena(int[] A){
        
        
         //Minimo
        int min = A[0]; //pega o primeiro elemento de A pra comparar
        for (int i = 1; i < A.length; i++) { //inicializa em 1 pois o max já tem o primeiro elemento a ser comparado
         
            if (A[i] < min) //se A[i] for maior que o min, ele passa a ser o max
           min = A[i];
        }
       
        
        //Maximo
         int max = A[0]; //pega o primeiro elemento de A pra comparar
            for (int i = 1; i < A.length; i++) { //inicializa em 1 pois o max já tem o primeiro elemento a ser comparado
             if (A[i] > max) //se A[i] for maior que o max, ele passa a ser o max
                     max = A[i];
            }
        
         
        int comprimento = A.length;    
        int intervalo = max - min + 1; 
        int vetorAux[] = new int[intervalo]; 
        int vetorOrd[] = new int[A.length]; 
        
         //1ª parte: Seta todo vetor auxiliar para zero
            for(int i = 0; i < comprimento; i++){
                vetorAux[i] = 0;
            }
        
        //2ª parte: Conta as frequências dos elementos do array principal e coloca no array auxiliar
        for(int j = 0; j < comprimento; ++j){  
   
            
           /*perceba que o A[j] está subtraindo com o valor mínimo pois agora que também existem
             números negativos no array;
             ele "empurra" as frequências de números positivos para a frente (quantidade de casas equivalente ao numero minimo)  
            */
            
            vetorAux[A[j] - min] = vetorAux[A[j] - min] + 1 ;  
            
            
        } 
        
         
        
        //3ª parte: Ordena o array auxiliar (que atualmente se encontra apenas com as frequências)
        for (int i = 1; i < intervalo; i++){   
           
           //a partir do índice 1, soma o elemento posterior com o anterior e e coloca no índice correspondente       
            vetorAux[i] = vetorAux[i] + vetorAux[i-1];
            
        } 
            
      
        
         //4ª parte: Ordena
        for (int j = comprimento - 1; j >= 0; j--){   
        
            vetorOrd[vetorAux[A[j] - min] - 1] = A[j]; //pega os elementos de A e coloca em vetorOrdenado(de trás pra frente)
          vetorAux[A[j]- min] = vetorAux[A[j]- min] - 1; //decrementa a posição que foi usada do vetorAux   
        
        } 
  
        //5ª parte: Armazena o vetor ordenado no vetor original
            for (int i = 0; i < comprimento; i++)
                A[i]= vetorOrd[i];
                    
            
        //6ª parte: Printa
            for(int juju = 0; juju<comprimento;juju++)
            System.out.println(A[juju]);
        
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
  
    
    public static void main(String[] args) throws FileNotFoundException 
    { 
       
        
        arquivo("src/num.1000.1.in");
        
        //colocando os elementos de Lista num array pra melhor visualização na função CountingSort
        int A[] = new int [lista.size()];
           for(int i = 0; i<lista.size();i++){
               A[i]=lista.get(i);
           }
        
        Ordena(A); 
        
    } 
}  
 

