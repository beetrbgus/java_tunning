package com.beetrb.java_tunning.chap08_synchronized;

/**
 * runnable 인터페이스를 구현하는 클래스
 */
public class RunnableImpl implements Runnable {
    @Override
    public void run() {
        System.out.println("This is RunnableImpl");
    }
}
