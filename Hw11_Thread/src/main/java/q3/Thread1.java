package main.java.q3;

class Thread1 extends Thread {
    SharedResource sharedResource;

    public Thread1(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sharedResource.doTaskForOneMinute();
    }
}
