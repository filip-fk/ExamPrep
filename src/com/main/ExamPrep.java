package com.main;

public class ExamPrep {
    public static void main(String[] args) {
        int i = 100;
        while(i>0)
        {
            System.out.println("--------");
            print();
            System.out.println("--------");
            i--;
        }
    }

    private static void print(){
        CW cw = new CW();
        cw.name = "A";
        Thread t1 = new Thread(cw);

        CW cw2 = new CW();
        cw2.name = "B";
        Thread t2 = new Thread(cw2);

        t1.start();
        t2.start();

        System.out.println("Fin");
    }
}
