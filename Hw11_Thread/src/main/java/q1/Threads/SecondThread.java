package main.java.q1.Threads;

import java.util.List;

public class SecondThread implements Runnable{
    private List<Integer> oddNumbers;
    private List<Integer> finalnumbers;

    public SecondThread(List<Integer> oddNumbers , List<Integer> finalnumbers) {
        this.oddNumbers = oddNumbers;
        this.finalnumbers = finalnumbers ;
    }

    @Override
    public void run() {
        for (int oddnumber: oddNumbers){
            synchronized (finalnumbers) {
                finalnumbers.add(oddnumber);
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