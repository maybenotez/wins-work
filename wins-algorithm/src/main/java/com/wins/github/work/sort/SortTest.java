package com.wins.github.work.sort;

public class SortTest {



    public static void main(String[] args) {
        int[] array = {1,1,1,4,2,3,6,7,1};

        Sort sort = new MergeSort();
    
        sort.sort(array);
    
    
        for(int i:array){
            System.out.print(i);
            System.out.print("=");
        }

        System.out.println("ending");
    }
    
}
