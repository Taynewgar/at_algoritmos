package at_algoritmos.program;

import java.util.Arrays;
import java.util.Random;

import at_algoritmos.quicksort.QuickSort;

class QuickSortMain {
  public static void main(String[] args) {
    // Random r = new Random();
    // Generation gen = new Generation();
    // System.out.print(gen); 
    int quantidadeRamdom = 10;
    int[] ordenada = {1,2,3,4,5,6,7,8,9,10};
    int[] lista = {1,5,8,9,6,4,4,5,3,2,1};
    int[] repetidos = {9,9,5,5,5,3,3,4,3,4,3,6,6,7,2,7,2,2,8,8,9,9,1,1,5,7,4,4,1,1,6,6,6,6,8,8};
    int[] invertida = {150, 125,98, 85, 77, 69, 66, 55, 43,42, 30, 30, 28, 11, 3};
    int[] aleatoria = geradorNumeros(quantidadeRamdom);

    System.out.println("Listas:");
        System.out.println("Lista Ordenada:");
        System.out.println(Arrays.toString(ordenada));
        System.out.println("Primeira Lista:");
        System.out.println(Arrays.toString(lista));
        System.out.println("Repepetidos:");
        System.out.println(Arrays.toString(repetidos));
        System.out.println("Lista Invertida:");
        System.out.println(Arrays.toString(invertida));
        System.out.println("Lista Aleatória");
        System.out.println(Arrays.toString(aleatoria) + "\n");       
        System.out.println("Quick Sort:");
        System.out.println("Quick Sort com 2 pivôs da Lista Ordenada");
        System.out.println(Arrays.toString(QuickSort.quickSort(ordenada, 0, ordenada.length - 1)));
        System.out.println("Quick Sort com 2 pivôs da Primeira Lista");
        System.out.println(Arrays.toString(QuickSort.quickSort(lista, 0, lista.length - 1)));
        System.out.println("Quick Sort com 2 pivôs da Lista de Repetidos");
        System.out.println(Arrays.toString(QuickSort.quickSort(repetidos, 0, repetidos.length - 1)));
        System.out.println("Quick Sort com 2 pivôs da Lista Invertida");
        System.out.println(Arrays.toString(QuickSort.quickSort(invertida, 0, invertida.length - 1)));
        System.out.println("Quick Sort com 2 pivôs da Lista Aleatória");
        System.out.println(Arrays.toString(QuickSort.quickSort(aleatoria)));
        System.out.println();




  }

  public static int[] geradorNumeros(int qtd){
        Random ran = new Random();
        int[] aleatorios = new int[qtd];
        for (int i = 0; i < qtd;i++){
            aleatorios[i] = ran.nextInt(1000);
        }
        return aleatorios;

  }

  

}