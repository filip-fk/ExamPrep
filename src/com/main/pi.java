package com.main;

import java.math.BigDecimal;
import java.util.stream.IntStream;

public class pi {
    public static void main(String[] args) {
        long t = System.nanoTime();
        for(int i = 0; i <100000; i ++)
        {
            //Th(i, System.nanoTime()).start();
            double temp = 1.0 / Math.pow(16, i);
            double temp1 = 4.0/(8.0*i+1);
            double temp2 = 2.0/(8.0*i+4);
            double temp3 = 1.0/(8.0*i+5);
            double temp4 = 1.0/(8.0*i+6);
            PI_ += temp*(temp1-temp2-temp3-temp4);
            BigDecimal bd = new BigDecimal(PI_);
            System.out.println(bd.toPlainString()+" : "+(System.nanoTime()-t));
        }
    }

    public static Thread Th (int min, long t) {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = min; i<min+100; i++) {
                    double temp = 1.0 / Math.pow(16, i);
                    double temp1 = 4.0/(8.0*i+1);
                    double temp2 = 2.0/(8.0*i+4);
                    double temp3 = 1.0/(8.0*i+5);
                    double temp4 = 1.0/(8.0*i+6);
                    PI_ += temp*(temp1-temp2-temp3-temp4);
                    System.out.println(PI_+" : "+(System.nanoTime()-t));
                }
            }
        });
    }

    public static double PI_ = Double.longBitsToDouble(0x0000000000000000L);
}
