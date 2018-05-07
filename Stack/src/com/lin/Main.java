package com.lin;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here

//        Stack<Integer> stack = new ArrayStack<>();
//        for ( int i = 0 ; i < 5 ; i++){
//            stack.push(i);
//            System.out.println(stack);
//        }
//
//        stack.pop();
//        System.out.println(stack);

        int opCount = 10000000;
        Stack<Integer> arrayQueue = new ArrayStack<>();
        double time1 = testStack(arrayQueue, opCount);
        System.out.println("ArrayStack, time: " + time1 + " s");

        Stack<Integer> loopQueue = new LinkedListStack<>();
        double time2 = testStack(loopQueue, opCount);
        System.out.println("LinkedListStack, time: " + time2 + " s");

    }


    //测试使用q运行opCount个enqueue和dequeue操作所需要的时间,单位：秒
    private static double testStack(Stack<Integer> q, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.pop();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) % 1000000000.0;
    }


}
