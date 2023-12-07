package org.example;

import java.util.ArrayList;

public class SumThread extends Thread {
    private ArrayList<Integer> array;
    private int low, high;
    private long partialSum;

    public SumThread(ArrayList<Integer> array, int low, int high) {
        this.array = array;
        this.low = low;
        this.high = Math.min(high, array.size());
        System.out.println("Hi I am a thread and my received limits are:" + low + " " + high +
                            ". As a total I have to iterate over " + (high-low) + " elements");
    }

    public void run() {
        partialSum = 0;
        for (int i = low; i < high; i++) {
            partialSum += array.get(i);
        }
    }

    public long getPartialSum() {
        return partialSum;
    }


}
