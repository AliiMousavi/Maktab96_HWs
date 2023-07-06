package main.java.q3;

class Thread2 extends Thread {
    SharedResource sharedResource;

    public Thread2(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sharedResource.doTaskForOneHour();
    }
}
