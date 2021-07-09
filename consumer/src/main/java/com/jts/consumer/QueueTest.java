package com.jts.consumer;

import lombok.SneakyThrows;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class QueueTest {
    static class TT extends Thread{

        @SneakyThrows
        @Override
        public void run() {
            for (;;){
                String str = queue.poll();
                if(Objects.isNull(str)){
                    if(lock.tryLock()){
                        try{
                            System.out.println("queue null,wait..");
                            condition.awaitUninterruptibly();
                        }finally {
                            lock.unlock();
                        }
                    }
                }else{
                    System.out.println(str);
                }
            }
        }
    }

    static Queue<String> queue = new ConcurrentLinkedQueue<String>();
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();
    static Thread th = new TT();

    public static void main(String[] args) throws Exception {

        th.start();

        for ( int i = 0; i<10;i++){
            queue.offer(String.valueOf(i));
            if(lock.tryLock()){
                try{
                    condition.signal();
                }finally {
                    lock.unlock();
                }
            }
        }

        Thread.sleep(10000);

        for ( int i = 0; i<10;i++){
            queue.offer(String.valueOf(i));
            if(lock.tryLock()){
                try{
                    condition.signal();
                }finally {
                    lock.unlock();
                }
            }
        }

       /* byte[] bys = "Hi，我你@@@@@@@@@@@@@@@@@@@@@@啊大大玩的".getBytes();
        String path = "D:/jts.txt";
        File file = new File(path+".tmp");
        if(!file.exists()){
                FileOutputStream out = new FileOutputStream(file);
                for (int i =0 ;i<1000;i++){
                        out.write(bys);
                }

                System.out.println("write file over..");
                out.flush();
                Thread.sleep(3000);
                System.out.println("flush file over..");
                out.close();
        }
        file.renameTo(new File(path));*/

    }
}
