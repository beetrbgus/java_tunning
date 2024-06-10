package com.beetrb.java_tunning.chap09_io;

import org.springframework.util.StopWatch;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * FileReader를 사용해 읽음.
 * 문자열 단위로 읽는 것은 매우 비효율적, 파일 크기가 크면 OutOfMemomeryError 발생
 */
public class BasicIOReadUtil {
    // 문자열을 하나씩 읽기 때문에 느림.
    public static List readCharStream(String fileName) throws IOException {
        List<StringBuffer> list = new ArrayList<>();
        FileReader fr = null;

        try {
            fr = new FileReader(fileName);
            int data = 0;
            StringBuffer sb = new StringBuffer();
            while ((data=fr.read()) != -1) {
                if(data == '\n' || data == '\r') {
                    list.add(sb);
                    sb = new StringBuffer();
                } else {
                    sb.append((char)data);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(fr != null) fr.close();
        }

        return list;
    }

    // bufferSize만큼씩 읽기 때문에 조금 더 빠름.
    public static String bufferReadCharStream(String fileName) throws IOException {
        StringBuffer retSB = new StringBuffer();
        FileReader fr = null;

        try {
            fr = new FileReader(fileName);
            int bufferSize = (int)Math.pow(1024, 2);
            char readBuffer[] = new char[bufferSize];
            int resultSize = 0;
            while ((resultSize = fr.read()) != -1) {
                if(resultSize == bufferSize) {
                    retSB.append(readBuffer);
                } else {
                    for (int i = 0; i < resultSize; i++) {
                        retSB.append(readBuffer[i]);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(fr != null) fr.close();
        }

        return retSB.toString();
    }

    public static void main(String[] args) throws Exception {
        String fileName= "";
        StopWatch sw = new StopWatch();
        sw.start();
        List list1 = BasicIOReadUtil.readCharStream(fileName);
        System.out.println(sw);
        String result = BasicIOReadUtil.bufferReadCharStream(fileName);
        sw.stop();
        sw.start();
        System.out.println(sw);
        System.out.println("list의 처리 결과  : " + list1.size());
        System.out.println("result의 처리 결과 : " + result.length());
    }
}
