package com.beetrb.java_tunning.chap08_synchronized;

/**
 * thread 클래스를 상속받는 클래스
 */
public class ThreadExtends extends Thread {
    @Override
    public void run() {
        System.out.println("This is ThreadExtends");
    }
}
