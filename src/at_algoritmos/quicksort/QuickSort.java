package at_algoritmos.quicksort;

public class QuickSort{

  public static int[] quickSort(int[] lista, int inicio, int fim){	 
     if(inicio < fim){   
		 if (lista[inicio] > lista[fim]){
	        swap(lista, inicio, fim);
		 }   	 

	     int esqPivo = partition(lista, inicio, fim)[0];    
	     int dirPivo = partition(lista, inicio, fim)[1]; 
	     quickSort(lista,inicio,esqPivo-1);
	     quickSort(lista,esqPivo+1,dirPivo-1);
	     quickSort(lista, dirPivo+1, fim);
    }
    return lista;
  }

  public static int[] quickSort(int[] lista){
    int inicio = 0;
    int fim = lista.length - 1;    
    return QuickSort.quickSort(lista, inicio, fim);
  }
  
  static int[] partition(int[] arr, int inicio, int fim){ 
     
      int j = inicio + 1; 
      int g = fim - 1, k = inicio + 1, 
          p = arr[inicio], q = arr[fim];             
      while (k <= g){ 
          if (arr[k] < p){ 
              swap(arr, k, j); 
              j++; 
          } 
          else if (arr[k] >= q){ 
              while (arr[g] > q && k < g) 
                  g--; 
                    
              swap(arr, k, g); 
              g--; 
                
              if (arr[k] < p) { 
                  swap(arr, k, j); 
                  j++; 
              } 
          } 
          k++; 
      } 
      j--; 
      g++; 
      swap(arr, inicio, j); 
      swap(arr, fim, g); 
      return new int[] { j, g }; 
  } 
  
  static void swap(int[] lista, int i, int j) {
	  int aux = lista[j];
      lista[j] = lista[i];
      lista[i] = aux;
  }


  








}