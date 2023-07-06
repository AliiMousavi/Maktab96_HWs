package main.java.q2;

import main.java.q2.threads.Thread1;
import main.java.q2.threads.Thread2;

public class Main {
    public static void main(String[] args){
        String lock1 = "lock1";
       String lock2 = "lock2";

        Thread thread1 = new Thread(new Thread1(lock1, lock2));
        Thread thread2 = new Thread(new Thread2(lock1, lock2));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
