package com.zeta;

import java.util.concurrent.Executors;

public class Worker extends Thread{
    private static Counter counter;
    public Worker(Counter counter) {
        this.counter=counter;
    }

    public void run(){
//        for(int i=0;i<10;i++){
//            try{
//                System.out.println("thread="+Thread.currentThread());
//                Thread.sleep(1000);
//            }
//            catch(InterruptedException e){
//                e.toString();
//            }
//        }
        counter.increment();
    }

    public static class ExecutorServiceDemo {
        public static void main(String[] args){
            ExecutorService executor = (ExecutorService) Executors.newSingleThreadExecutor();
            executor.submit(new Worker(counter));
            executor.shutdown();
        }
    }

    public static class ExecutorService {
        public void submit(Worker worker) {
        }

        public void shutdown() {
        }
    }
}
