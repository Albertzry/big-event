package org.example;

import org.junit.jupiter.api.Test;

public class ThreadLocalTest {

    @Test
    public void testThreadLocalSetAndGet(){
        ThreadLocal t1 = new ThreadLocal<>();

        new Thread(()->{
            t1.set("123");
            System.out.println(Thread.currentThread().getName()+":"+t1.get());
            System.out.println(Thread.currentThread().getName()+":"+t1.get());
            System.out.println(Thread.currentThread().getName()+":"+t1.get());
        },"blue").start();

        new Thread(()->{
            t1.set("456");
            System.out.println(Thread.currentThread().getName()+":"+t1.get());
            System.out.println(Thread.currentThread().getName()+":"+t1.get());
            System.out.println(Thread.currentThread().getName()+":"+t1.get());
        },"green").start();
    }
}
