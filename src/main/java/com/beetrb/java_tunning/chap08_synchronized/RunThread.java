package com.beetrb.java_tunning.chap08_synchronized;

public class RunThread {
    public static void main(String[] args) {
        RunnableImpl ri = new RunnableImpl();
        ThreadExtends te = new ThreadExtends();
        new Thread(ri).start();
        te.start();
        // 결과는 ri te 고정되지 않고 무작위로 호출된다.
    }
}
