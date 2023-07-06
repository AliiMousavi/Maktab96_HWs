package main.java.q2.threads;

public class Thread1 implements Runnable{

    private final String firstLock;
    private final String secondLock;

    public Thread1(String firstLock, String secondLock) {
        this.firstLock = firstLock;
        this.secondLock = secondLock;
    }

    @Override
    public void run() {

        synchronized(firstLock) {
            System.out.println("Thread1 get firstLock");

            try {
                Thread.sleep(2000);
                System.out.println("Thread1 wait to Thread2 release the secondLock");
                secondLock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
