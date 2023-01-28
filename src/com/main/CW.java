package com.main;

public class CW implements Runnable{
    @Override
    public void run() {
        System.out.println(name);
    }

    public String name;
}
