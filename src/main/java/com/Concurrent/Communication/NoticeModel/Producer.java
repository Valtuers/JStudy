package com.Concurrent.Communication.NoticeModel;

/**
 * 生产者
 */
public class Producer implements Runnable {
    private Medium medium;

    public Producer(Medium medium) {
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
            medium.put();
        }
    }
}
