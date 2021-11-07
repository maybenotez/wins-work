package com.wins.github.work.sort;

public class QuickSort implements Sort{

    @Override
    public void sort(int[] array) {
    

        sort(array,0,array.length-1);
    }


    private void sort(int[] array,int low,int high){

        if(low >= high){
            return;
        }
        int index = findPart(array, low, high);


        sort(array,low,index-1);

        sort(array,index+1,high);

    }

    private int findPart(int[] array,int low,int high){


        int key = array[low];


        while(low < high){

            while(high > low && array[high] > key){
                high--;
            }

            swap(array, low, high);


            while(low < high && array[low] < key){
                low++;
            }
            
            swap(array, low, high);   

        }

        array[low] = key;
        return low;
    }

    
    
}
