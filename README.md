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

