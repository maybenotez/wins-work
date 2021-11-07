package com.wins.github.work.sort;

public class MergeSort implements Sort{

    private int[] initialArray;

    @Override
    public void sort(int[] array) {

        initialArray = new int[array.length];
        

        mergeSort(array, 0, array.length-1);
    }


    private void mergeSort(int[] array,int low,int high){

        if(low >= high){
            return;
        }
        int mid = (low + high)/2;

        mergeSort(array, low, mid);

        mergeSort(array, mid+1, high);

        merge(array, low, high, mid);

    }

    private void merge(int[] array,int low,int high,int mid){


        int i = low;
        int j = mid+1;
        int index = low;
        while(i <= mid && j <= high){
            
            if(array[i] > array[j]){
                initialArray[index] = array[j];
                j++;
            }else{
                initialArray[index] = array[i];
                i++;
            }
            index++;
        }

        while(i<=mid){
            initialArray[index] = array[i];
            i++;
            index++;
        }

        while(j<=high){
            initialArray[index] = array[j];
            j++;
            index++;
        }
        int k = low;
        int g = mid+1;
        int m = low;
        while(m < index){

            if(k <= mid){
                array[k] = initialArray[m];
                k++;
            }else if(g <= high){
                array[g] = initialArray[m];
                g++;
            }
            m++;
        }
    }
    
}
