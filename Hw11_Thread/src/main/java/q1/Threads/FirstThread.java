package main.java.q1.Threads;

import java.util.ArrayList;
import java.util.List;

public class FirstThread implements Runnable{
    private List<Integer> evenNumbers;
    private List<Integer> finalnumbers;

    public FirstThread(List<Integer> evenNumbers , List<Integer> finalnumbers) {
        this.evenNumbers = evenNumbers;
        this.finalnumbers = finalnumbers;
    }

    @Override
    public void run() {
        for (int evennumber: evenNumbers){
            synchronized(finalnumbers) {
                finalnumbers.add(evennumber);
                finalnumbers.notify();

                try {
                    finalnumbers.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
