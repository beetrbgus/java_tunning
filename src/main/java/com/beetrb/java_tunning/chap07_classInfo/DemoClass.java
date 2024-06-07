package com.beetrb.java_tunning.chap07_classInfo;

import java.io.IOException;

public class DemoClass {
    private String privateField;
    String field;
    protected String protectedField;
    public String publicField;

    public DemoClass() {

    }

    public DemoClass(String args) {}

    public void publicMethod() throws Exception, IOException {}

    public String publicMethod(String s, int i) {
        return "s="+ s + " i=" + i;
    }

    protected void protectedMethod() {}

    private void privateMethod() {}

    void method() {}

    public String publicRetMethod() {
        return null;
    }

    public InnerClass getInnerClass() {
        return new InnerClass();
    }

    public class InnerClass {
    }
}
