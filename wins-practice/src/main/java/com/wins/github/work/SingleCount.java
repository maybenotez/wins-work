package com.wins.github.work;

public class SingleCount implements Count {

    private int size;

    @Override
    public void addOne() {
        synchronized (this){
            size++;
        }
    }

    @Override
    public int size() {
        return size;
    }
}
