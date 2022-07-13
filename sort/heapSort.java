/*
 * Heap Sort
 * Author: Qing "Matt" Zhang
 * https://sites.google.com/site/mattzhangcube/home/coding 
- Heap sort:
    Idea: First we build heap, then we remove the root, move the last leaf to root, then heapify from the new root.
    Complexity: NlogN
    Construction of heap is very useful in finding the top K problems.
*/

public class heapSort {
  
   public static void swap(int[] InArray, int i, int j)
   {
      int tmp;
      tmp = InArray[i];
      InArray[i] = InArray[j];
      InArray[j] = tmp;
   }  
  
   public static void heapify(int[] inArray, int idx, int end)   //max heap
   {
      int left = idx * 2 + 1;
      if(left > end)  //already leaf node
         return;
     
      int right = idx * 2 + 2;
      if (right<=end)
      {
         if (inArray[left] > inArray[right])
         {
            if(inArray[idx] < inArray[left])
            {
               swap(inArray, idx, left);
               heapify(inArray,left, end);
            }
         }else
         {
            if(inArray[idx] < inArray[right])
            {
               swap(inArray, idx, right);
               heapify(inArray, right, end);
            }
         }
      }else  //no right child
      {
         if(inArray[idx] < inArray[left])       
            swap(inArray, idx, left);        
      }
   }
  
   public static void HeapSort(int[] inArray)
   {
      //build heap
      for (int i = inArray.length/2-1; i>=0; i--)     
         heapify(inArray, i, inArray.length-1);
     
      //remove first, and heapify remaining
      for(int end=inArray.length-1; end>=0; end--)
      {
         swap(inArray, 0, end);
         heapify(inArray, 0, end-1);        
      }
   }
  
   /***********************************
   Testing
  ***********************************/
  //static int inArray[] = {2, 8, 6, 3, 9, 4, 10, 1, 7, 5};
  static final int inArray[] = {11, 2, 8, 15, 6, 3, 13, 9, 4, 14, 17, 10, 1, 16, 7, 5, 12};
 
  public static void main(String[] args)
  {
     int length = inArray.length;   
     int myArray[] = new int[length];

     /* Heap Sort */
     System.arraycopy(inArray, 0, myArray, 0, length);
     HeapSort(myArray);
         
     for (int i=0; i<myArray.length; i++)
     {
        System.out.print(myArray[i] + " ");
     }
  }
}

