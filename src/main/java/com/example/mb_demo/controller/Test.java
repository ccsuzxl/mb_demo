package com.example.mb_demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    static void test1() throws ExecutionException, InterruptedException {
        Date start=new Date();
        System.out.println(start.getTime());
        long count=0;
        for (int i = 1; i <= 100000000; i++) {
            count=count+i;
        }
        System.out.println("count="+count);
        Date end=new Date();
        System.out.println(end.getTime());
        System.out.println(end.getTime()-start.getTime());
        long count2=0;
        FutureTask<Long> futureTask=new FutureTask<Long>(new MyThread(1,50000000));
        FutureTask<Long> futureTask2=new FutureTask<Long>(new MyThread(50000000,100000001));
        new Thread(futureTask).start();
        new Thread(futureTask2).start();
        count2=count2+futureTask.get();
        count2=count2+futureTask2.get();
        System.out.println("count2="+count2);
        Date end2=new Date();
        System.out.println(end2.getTime());
        System.out.println(end2.getTime()-end.getTime());
    }
    static void test2() throws IOException {
        List<String> list = Arrays.asList("Ok", "SLsdiS", "alibaba", "tengxun", "Baidu","app");
        Stream<String> stream = list.stream();
        List<String> a = stream.filter(s->s.contains("a"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(a);

        Stream<String> lines = Files.lines(Paths.get("E://111.txt"));
        List<String> collect = lines.collect(Collectors.toList());
        System.out.println(collect);
    }

    public static void main(String[] args) throws Exception {
        SimpleDateFormat instance = SingletonEnum.INSTANCE.getInstance();
        SimpleDateFormat instance2 = SingletonEnum.INSTANCE.getInstance();
        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
    }
}

class MyThread implements Callable<Long> {
    private int b;
    private int e;

    public MyThread(int b,int e){
        this.b=b;
        this.e=e;
    }
    @Override
    public Long call() throws Exception {
        long count=0;
        for (int i = this.b; i < this.e; i++) {
            count=count+i;
        }
        return count;
    }
}

class OneSingle{
    private static OneSingle oneSingle=null;

    public static OneSingle getInstance() throws InterruptedException {
        if(oneSingle==null){
            Thread.sleep(2);
            oneSingle = new OneSingle();
        }
        return oneSingle;
    }

}