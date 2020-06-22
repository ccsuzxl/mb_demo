package com.example.mb_demo.controller;

public class Test2 {
    public static ThreadLocal<Integer> tl=new ThreadLocal<>();
    public static ThreadLocal<Integer> tl2=new ThreadLocal<>();
    public void f1()  {
        try {
            System.out.println("f1 start");
            Thread.sleep(100);
            System.out.println("f1 end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void f2() {
        try {
            System.out.println("f2 start");
            Thread.sleep(300);
            System.out.println("f2 end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static Test2 t=null;
    synchronized public static Test2 getInstance(){
        if(t==null){
            t=new Test2();
        }
        return t;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() ->{
            Test2 t1= Test2.getInstance();
            synchronized (t1){
                t1.f1();
            }
            Test2.tl.set(11);
            Test2.tl2.set(111);
            System.out.println(tl.get()+" "+tl2.get());
            System.out.println();
        });
        Thread t2 = new Thread(()->{
            Test2 t1=Test2.getInstance();
            synchronized (t1){
                t1.f2();
            }
            Test2.tl.set(22);
            Test2.tl2.set(222);
            System.out.println(tl.get()+" "+tl2.get());
        });
        t2.start();
        t.start();
        System.out.println(try1("10"));
    }
    public static String try1(String a){
        try {
            a="20";
            return a;
        }catch (Exception e){

        }finally {
            a="30";
            return a;
        }
    }
}
