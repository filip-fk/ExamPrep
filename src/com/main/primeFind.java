package com.main;

import java.util.ArrayList;

import static java.lang.System.out;
import static java.util.Arrays.stream;
import static java.util.Comparator.comparing;




public class primeFind {
    public static void main(String[] args) {
        //int p = 554130654;

        long time = System.nanoTime();
        /////////////////////////////////////////
        stream(NUMBERS)
                .unordered()
                .parallel()
                .mapToObj(primeFind::minimalPrimeFactor)
                .max(comparing(a -> a.get(0)))
                .ifPresent(res -> out.printf(
                        "%d has the largest minimum prime factor: %d%nand additionally has factors %s%n",
                        res.get(0),
                        res.get(1),
                        f_res(res)
                ));
        /////////////////////////////////////////
        time = System.nanoTime() - time;

        //for (int i=0; i<p.size(); i++)
            //System.out.print(p.get(i) + " ");

        System.out.println(time);
    }

    public static String f_res (ArrayList<Long> res){
        res.remove(0);
        res.remove(1);
        StringBuilder res_ = new StringBuilder();
        for(Long l : res)
            res_.append(l.toString()+", ");

        return res_.toString();
    }

    public static final long[] NUMBERS = {
            554130654
    };

    public static ArrayList<Long> minimalPrimeFactor(long n) {
        ArrayList<Long> res = new ArrayList<Long>();
        res.add(n);
        for (long i = 2; n >= i * i; i++) {
            if (n % i == 0) {
                res.add(i);
            }
        }

        res.add(n);
        return res;
    }
}
