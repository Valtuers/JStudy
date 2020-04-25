package com.Concurrent.Communication.NoticeModel;

public class Consumer implements Runnable {
    private Medium medium;

    public Consumer(Medium medium) {
        this.medium = medium;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(800L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            medium.take();
        }
    }
}
