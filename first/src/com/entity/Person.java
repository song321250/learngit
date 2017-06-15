package com.entity;

/**
 * Created by song on 2017/5/18.
 */
public class Person {

    private int pid;
    private String username;
    private String password;
    public Person(){}
    public Person(int pid, String username, String password) {
        this.pid = pid;
        this.username = username;
        this.password = password;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
