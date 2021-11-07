package com.wins.github.work.sort;



public class InsertSort implements Sort{

    

    @Override
    public void sort(int[] arrya) {
        
        

        for(int i=0;i<arrya.length;i++){


            insert(arrya, 0, i-1, i);
        }

        
    }

    private void insert(int[] array,int low,int high,int index){


        if(high <0){
            return;
        }

        for(int i = high;i>=low;i--){

            if(array[i] > array[index]){
                swap(array, i, index);
                index = i;
            }else{
                break;
            }
        }
    }




}