package com.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by song on 2017/6/6.
 */
public class Redemo {
    public static void main(String[] args) {
        String p = "(.*)(\\d+)(.*)";
        String line  = "this is order was placed for qt3000! OK?";
        Pattern r =Pattern.compile(p);
        Matcher m =r.matcher(line);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
        } else {
            System.out.println("NO MATCH");
        }
    }
}
