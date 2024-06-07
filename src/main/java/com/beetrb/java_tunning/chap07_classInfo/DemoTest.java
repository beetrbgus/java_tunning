package com.beetrb.java_tunning.chap07_classInfo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class DemoTest {
    public static void main(String argsp[]) {
        DemoClass dc = new DemoClass();

        DemoTest dt = new DemoTest();
        dt.getClassInfo(dc);
    }

    public void getClassInfo(Object clazz) {
        Class demoClass = clazz.getClass();
        getClassInfo(demoClass);
         getFieldInfo(demoClass);
         getMethodInfo(demoClass);
    }

    public void getClassInfo(Class demoClass) {
        String className = demoClass.getName();
        String classCanonicalName = demoClass.getCanonicalName();
        String classSimpleName = demoClass.getSimpleName();
        String packageName = demoClass.getPackageName(); // java 9 버전 이상
        String toString = demoClass.toString();

        System.out.println("Class Name :  " + className);
        System.out.println("classCanonicalName :  " + classCanonicalName);
        System.out.println("classSimpleName :  " + classSimpleName);
        System.out.println("packageName :  " + packageName);
        System.out.println("toString :  " + toString);
    }

    public void getMethodInfo(Class demoClass) {
        System.out.println("------------------- Method Info ----------------------");
        Method[] method1 = demoClass.getDeclaredMethods();
        Method[] method2 = demoClass.getMethods();

        System.out.println("Declare Methods : " + method1.length + "  Methods : " + method2.length);

        for (Method met1 : method1) {
            String name = met1.getName();
            int modifiers = met1.getModifiers();
            String modifierStr = Modifier.toString(modifiers);
            String returnType = met1.getReturnType().getSimpleName();
            Class params[] = met1.getParameterTypes();

            StringBuilder sb = new StringBuilder();
            int paramLength = params.length;

            if(paramLength != 0) {
                sb.append(params[0].getSimpleName()).append(" arg");

                for (int i = 1; i < paramLength; i++) {
                    sb.append(", ")
                        .append(params[i].getName())
                        .append(" arg").append(i);
                }
            }

            Class exceptions[] = met1.getExceptionTypes();
            StringBuilder eb = new StringBuilder();
            int exceptionLength = exceptions.length;

            if(exceptionLength != 0) {
                eb.append("throws ")
                    .append(exceptions[0].getName());

                for (int i = 1; i < exceptionLength; i++) {
                    eb.append(", ")
                        .append(exceptions[i].getSimpleName());
                }
            }

            System.out.println("name   : "  + name);
            System.out.println("modifierStr   : "  + modifierStr);
            System.out.println("returnType   : "  + returnType);
            System.out.println("sb   : "  + sb);
            System.out.println("eb   : "  + eb);

        }
    }

    public void getFieldInfo(Class demoClass) {
        System.out.println("-------------------- FieldInfo ---------------------");

        Field[] field1 = demoClass.getDeclaredFields();
        Field[] field2 = demoClass.getFields();

        System.out.println("Declare Fields : " + field1.length + "  Fields : " + field2.length);

        for (Field field : field1) {
            String name = field.getName();
            int modifier = field.getModifiers();
            String modifierStr = Modifier.toString(modifier);
            String type = field.getType().getSimpleName();
            System.out.println("name    :  " + name);
            System.out.println("type    :  " + type);
            System.out.println("modifierStr    :  " + modifierStr);
        }
        System.out.println("-----------------------------------------");
        for (Field field : field2) {
            String name = field.getName();
            int modifier = field.getModifiers();
            String modifierStr = Modifier.toString(modifier);
            String type = field.getType().getSimpleName();
            System.out.println("name    :  " + name);
            System.out.println("type    :  " + type);
            System.out.println("modifierStr    :  " + modifierStr);
        }
    }
}
