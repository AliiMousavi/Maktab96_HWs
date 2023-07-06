package main.java.q3;

public class SharedResource {
    public synchronized void doTaskForOneMinute() {
        System.out.println("Thread 1 doing task For One Minute...");
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void doTaskForOneHour() {
        System.out.println("Thread 2 doing task For One Hour...");
        try {
            Thread.sleep(3600000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
