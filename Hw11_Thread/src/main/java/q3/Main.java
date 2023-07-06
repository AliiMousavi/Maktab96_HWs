package main.java.q3;

public class Main{
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread1 thread1 = new Thread1(sharedResource);
        Thread2 thread2 = new Thread2(sharedResource);

        thread1.start();
        thread2.start();
    }
}
