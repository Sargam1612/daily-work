package com.zeta;

import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Integer>{
    private static final int THRESHOLD = 450;
    private Account[] arr;
    private int start,end;

    public SumTask(Account[] arr,int start,int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if(end - start <=THRESHOLD){
            int sum=0;
            for( int i=start;i<end;i++){
                sum = arr[i].getBalance() + sum;
            }
            return sum;
        }
        else{
            int mid = (start+end)/2;
            SumTask left = new SumTask(arr,start,mid);
            SumTask right = new SumTask(arr,mid,end);
            right.fork();
            int leftResult = left.compute();
            int rightResult = right.join();
            return leftResult+rightResult;
        }
    }
}
