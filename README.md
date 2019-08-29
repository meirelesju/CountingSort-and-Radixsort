# Linear Sorting


## Counting Sort

O Counting Sort é um algoritmo que ordena vetores de inteiros onde os valores estão dentro de um intervalo de 1 a K. 
O mesmo utiliza um vetor auxiliar onde são feitas as operações que o algoritimo necessita.

### Etapas

O Counting Sort geralmente opera da seguinte maneira:

```
1 – Inicializa os elementos do vetor auxiliar com zeros
2 – Conta as frequências dos elementos do array principal e as coloca como índice no array auxiliar
3 – Ordena o vetor auxiliar
4 – Transfere os valores do vetor auxiliar nos seus respectivos índices para o vetor de entrada
```

### Problemas encontrados

O algoritmo precisa operar também no intervalo de números inteiros (Z). Há priori, ele estava ordenando apenas números positivos. 


**Solução**

Uma maneira encontrada para corrigir esse problema foi "empurrar" as frequências dos números positivos para frente do vetor auxiliar 
(com a quantidade de casas avançadas equivalente ao menor número do vetor principal) para que no início fiquem as frequências dos números negativos.

**Exemplo**

Usando como entrada A = {2, 5, 3, 0, 2, 3, 0, 3, -1}:

![exemplo1](https://user-images.githubusercontent.com/32073212/63956982-ebe60380-ca5d-11e9-83b4-5a39baa251bb.png)


## Radix Sort

O Radix Sort é um algoritmo que ordena vetores de inteiros, onde ele opera sobre os dígitos de cada elemento sempre começando pelo dígito menos significativo (dígito mais à direita).

### Algoritmo

```
Algorithm Radix-Sort(A,n,d)
1: for i = 1 to d do
2: ORDENE(A, n, i);
3: end for
```
Note que ele usa o ORDENE, que nada mais é que o próprio CountingSort com poucas modificações.
Ou seja, ele dá *CountingSort* para cada dígito dos elementos do vetor inicial.

### Problemas encontrados

Como então saber sobre qual dígito ele deve operar e qual seu limite?

Em java, o maior int de 32 bits é **2147483647**, ou seja, na casa do bilhão. Então, o limite dos dígitos das entradas é na casa do **bilhão** (1.000.000.000).

* No código trabalhado neste repositório, ele vai pegar o elemento inicial (**3** por exemplo) 
* Dividir o elemento inicial pelo *i* que está sendo trabalhado atualmente (se estivermos na casa das dezenas, vai se tornar **0,3**) 
```
No for do algoritmo, o "i" diz em qual "casa" estamos trabalhando atualmente 
            (unidades, dezenas, centenas, milhares, etc) 
```
 * Pegar o elemento mais à direita (o **3**) e executar o resto do código com ele.

Note que os números com apenas uma casa decimal serão preenchidos com zeros à esquerda para que o algoritmo opere corretamente.

Com isto, garantimos que o CountingSort vai operar sobre todas as casas existentes.  

## Autores

* **Julianny Meireles** - *All work* - [Meirelesju](https://github.com/meirelesju)


## Licença

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Referências

* Slides fornecidos pelo professor 
* Counting Sort - [Wikipédia](https://pt.wikipedia.org/wiki/Counting_sort)
* Radix Sort - [Wikipédia](https://pt.wikipedia.org/wiki/Radix_sort)


