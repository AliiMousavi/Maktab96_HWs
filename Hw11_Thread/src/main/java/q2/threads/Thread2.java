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
            System.out.println("Thread2 get secondLock");

            try {
                Thread.sleep(1000);
                System.out.println("Thread2 wait to Thread1 release the firstLock ");
                firstLock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();            }
        }

    }
}
