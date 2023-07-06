package main.java.q2.threads;

public class Thread2 implements Runnable{

    private final String firstLock;
    private final String secondLock;

    public Thread2(String firstLock, String secondLock) {
        this.firstLock = firstLock;
        this.secondLock = secondLock;
    }

    @Override
    public void run() {

        synchronized(secondLock) {
            System.out.println("Thread1 get firstLock");

            try {
                Thread.sleep(1000);
                firstLock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();            }
        }

    }
}
