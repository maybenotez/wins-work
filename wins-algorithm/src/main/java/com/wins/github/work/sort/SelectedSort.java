package com.wins.github.work.sort;

public class SelectedSort implements Sort{



   public static void main(String[] args) {
       
   
   }
    

    @Override
    public void sort(int[] arrya) {
       
        sort(arrya, 0, arrya.length-1);
        
    }

    private void sort(int[] array,int low,int high){

        if(low > high){
            return;
        }
        int min = findMinIndex(array, low, high);

        swap(array, low, min);

        sort(array, low+1, high);
    }

    private int findMinIndex(int[] array,int low,int high){

        int result = array[low];
        int min = low;
        while(low <= high){

            if(array[low] < result){
                result = array[low];
                min = low;
            }
            low++;
        }
        return min;
    }
}