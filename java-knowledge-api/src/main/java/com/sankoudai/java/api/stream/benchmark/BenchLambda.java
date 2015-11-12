package com.sankoudai.java.api.stream.benchmark;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : sankoudai
 * @version : created at 2015/10/22
 */
public class BenchLambda {
    public static final Integer SIZE = 300;
    public static final Integer LOOP_COUNT = 1000000;

    /**
     * BenchLambda: array size = 300, loop_count = 1000000
     *  --------------------------------------------------
     * The cost of lambda benchmark: 29.464 s
     * The cost of lambda benchmark: 27.869 s
     * The cost of lambda benchmark: 29.943 s
     * The cost of lambda benchmark: 30.536 s
     * The cost of lambda benchmark: 30.236 s
     * The cost of lambda benchmark: 29.453 s
     * The cost of lambda benchmark: 28.706 s
     * The cost of lambda benchmark: 28.832 s
     * The cost of lambda benchmark: 30.23 s
     * The cost of lambda benchmark: 28.356 s
     * The cost of lambda benchmark: 29.171 s
     * The cost of lambda benchmark: 25.95 s
     * The cost of lambda benchmark: 29.776 s
     * The cost of lambda benchmark: 30.108 s
     * The cost of lambda benchmark: 30.661 s
     * ----------------------------------------------------
     * The cost of baseline benchmark: 13.757 s
     * The cost of baseline benchmark: 13.778 s
     * The cost of baseline benchmark: 12.672 s
     * The cost of baseline benchmark: 12.669 s
     * The cost of baseline benchmark: 12.723 s
     * The cost of baseline benchmark: 12.683 s
     * The cost of baseline benchmark: 12.665 s
     * The cost of baseline benchmark: 12.671 s
     * The cost of baseline benchmark: 12.695 s
     * The cost of baseline benchmark: 12.719 s
     * The cost of baseline benchmark: 12.707 s
     * The cost of baseline benchmark: 12.682 s
     * The cost of baseline benchmark: 12.682 s
     * The cost of baseline benchmark: 12.752 s
     * The cost of baseline benchmark: 12.69 s
     */
    @Test
    public void testLambda(){
        System.out.printf("BenchLambda: array size = %s, loop_count = %s \n", SIZE, LOOP_COUNT);
        System.out.println("---------------------------------------------------------------");
        for(int i= 0; i < 15; i++){
            lambda();
        }

        System.out.println("---------------------------------------------------------------");
        for (int i = 0; i<15; i++){
            baseline();
        }
    }


    private void lambda(){
        List<Integer> ints = intList();

        long start = System.currentTimeMillis();

        for(int index = 0; index< LOOP_COUNT; index++){
            List<Integer> collector = ints.stream().map(j->j+4301).map(j->j-19).map(j->(int)(j/31)).collect(Collectors.toList());
        }

        Long cost = System.currentTimeMillis() - start;

        System.out.printf("The cost of lambda benchmark: %s s\n", cost.doubleValue()/1000.0);
    }

    private void baseline(){
        List<Integer> ints = intList();
        long start = System.currentTimeMillis();

        for(int index = 0; index< LOOP_COUNT; index++){
            List<Integer> collector = new ArrayList<>();

            for(Integer i : ints){
                int j = i + 4301;
                j = j - 19;
                j = j / 31;
                collector.add(j);
            }
        }

        Long cost = System.currentTimeMillis() - start;

        System.out.printf("The cost of baseline benchmark: %s s \n", cost.doubleValue()/1000.0);
    }

    private List<Integer> intList(){
        List<Integer> ints = new ArrayList<>(SIZE);
        for(int i=0; i< SIZE; i++){
            ints.add(i);
        }

        return ints;
    }
}
