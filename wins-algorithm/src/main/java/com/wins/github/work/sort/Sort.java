package com.wins.github.work.sort;

public interface Sort {


    void sort(int[] array);


    default void swap(int[] array,int left,int right){

        int m = array[left];

        array[left] = array[right];

        array[right] = m;
    }
    
}
