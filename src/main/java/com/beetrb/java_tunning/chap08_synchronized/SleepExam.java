package com.beetrb.java_tunning.chap08_synchronized;

public class SleepExam extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Somebody stopped me ㅠㅅㅠ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SleepExam se = new SleepExam();
        se.start();

        try {
            for (int i = 0; i < 5; i++) {
                se.join(1000);

                System.out.println("1초 기다림-");
            }
            if(se.isAlive()) {
                se.interrupt();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
