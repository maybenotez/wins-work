package com.wins.github.work.sort;

public class HeapSort implements Sort{

    @Override
    public void sort(int[] array) {
        
        

        int high = array.length-1;

        while(high > 0){
            buildHeap(array, 0, high);

            System.out.println(array[0]);
            swap(array, 0, high);
            high--;
            buildHeap(array, 0, high);
            
        }
        
    }


    private void buildHeap(int[] array,int low,int high){
        
        int lastParent = (high-1)/2;

        while(lastParent >= low ){

            heapTree(array, low, high, lastParent);
            lastParent--;
        }
    }


    private void heapTree(int[] array,int low,int high, int index){
        if(index < low || index > high){
            return;
        }
        int root = array[index];

        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if(right <= high){

            if(array[right] > array[index] && array[right] > array[left]){

                swap(array, right, index);

                heapTree(array, low, high, right);
            }
            else if(array[left] > array[index] && array[left] > array[right]){
                swap(array, left, index);

                heapTree(array, low, high, left);
            }

        }else if(left <= high){
            if(array[left] > array[index]){

                swap(array, left, index);

                heapTree(array, low, high, left);
            }
        }
        
    }
    
}
