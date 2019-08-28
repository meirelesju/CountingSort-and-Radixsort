
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    public void Ordena(ArrayList<Integer> A){
        
        int comprimento = A.size(); // tamanho do array original
        
        int vetorAux [] = new int [comprimento]; // vetor que será o auxiliar ("C" nos slides)
        int vetorOrd [] = new int [comprimento]; // vetor que terá os numeros ja ordenanos ("B" nos slides)
       
        
        //1ª parte: Seta todo vetor auxiliar para zero
        for(int i = 0; i < comprimento; i++){
            vetorAux[i] = 0;
        }
        
        //2ª parte: Conta as frequências dos elementos do array principal e coloca no array auxiliar
        for(int j = 0; j < comprimento; j++){
            
            // O elemento na posição A[j] = ao elemento na posição A[j] + 1
            // A[j] é o array principal, ou seja, possui os números de entrada
            vetorAux[A.get(j)] = vetorAux[A.get(j)] + 1; 
   
        }
       
        //Função pra encontrar o maior elemento de A pra usar no proximo passo
        int max = A.get(0); //pega o primeiro elemento de A pra comparar
        for (int i = 1; i < comprimento; i++) { //inicializa em 1 pois o max já tem o primeiro elemento a ser comparado
         if (A.get(i) > max) //se A[i] for maior que o max, ele passa a ser o max
        	 max = A.get(i);
        }
      
        //System.out.println("Max: "+ max );
            
        //3ª parte: Ordena o array auxiliar (que atualmente se encontra apenas com as frequências) do menor para o maior    
        for(int i = 1; i <= max ; i++){
   
        //a partir do índice 1, soma o elemento posterior com o anterior e e coloca no índice correspondente       
         vetorAux[i] = vetorAux[i] + vetorAux[i-1];
        
         }
        //for(int juju = 0; juju<comprimento;juju++)
            //System.out.println(vetorAux[juju]);
        
    
        //4ª parte: Ordena
        for(int j = comprimento-1; j >= 0; j--){
   
            vetorOrd[vetorAux[A.get(j)]-1] = A.get(j);//pega os elementos de A e coloca em vetorOrdenado(de trás pra frente)
            vetorAux[A.get(j)] = vetorAux[A.get(j)] - 1; //decrementa a posição que foi usada do vetorAux       
        }   
    }
    
        //Lê o arquivo e coloca os elementos na "lista"
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
    
  
   public static void main(String args[]) throws FileNotFoundException 
    { 
        //Abre o arquivo
        arquivo("src/aaa.in");
         
        CountingSort hehe = new CountingSort(); 
        hehe.Ordena(lista); 
   
    } 

} 

    
    
    

