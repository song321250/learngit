package com.demo;

/**
 * Created by song on 2017/6/6.
 */
public class StringDemo {
    public static void main(String[] args) {
        StringBuffer sb =new StringBuffer("test");
        sb.append("java");
        System.out.println(sb);
        StringBuilder sd = new StringBuilder("asd");
        sd.append("java");
        System.out.println(sd);
    }
}
