package com.yorick.pro_java_test.java_base.multi_thread.thread;

import java.util.concurrent.*;

public class TestThread {

    public static void main(String[] args) {

        /**
         * 方式一
         */
        // 启动一个新的线程
//        new Thread(new Task()).start();
//        // main线程打印数据
//        System.out.println(Thread.currentThread().getName() + "———— Main ———— 实现Runnable接口方式");

        /**
         * 方式二
         */
        // 启动一个新的线程
//        new SubThread().start();
//        // main线程打印一句话
//        System.out.println(Thread.currentThread().getName() + "———— Main ———— 继承Thread方式");

        /**
         * 方式三
         */
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Boolean> yorick = executorService.submit(new TaskCall("yorick"));
        Future<Boolean> yorickLi = executorService.submit(new TaskCall("yorick-li"));

        try {
            Boolean aBoolean = yorick.get();
            Boolean bBoolean = yorickLi.get();
            System.out.println("yorick: " + aBoolean);
            System.out.println("yorick-li: " + bBoolean);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

}

/**
 * 方式一
 * Runnable：启动一个新线程
 */
class Task implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "———— Task");
    }
}

/**
 * 方式二
 * 继承：Thread 类
 */
class SubThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "———— Task");
    }
}

/**
 * 方式三
 * 实现 Callable 接口
 */
class TaskCall implements Callable<Boolean> {

    private String name;

    public TaskCall(String name) {
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {
        Boolean flag = false;

        // TODO TASK
        System.out.println(name);
        if ("yorick".equals(name)) {
            flag = true;
        }

        return flag;
    }

    public static void main(String[] args) {
        System.out.println("跑出异常前");
        boolean flag = true;
        if (flag) {
            throw new StringIndexOutOfBoundsException();
        }
        System.out.println("跑出异常后");
    }
}