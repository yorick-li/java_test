package com.yorick.pro_java_test.java_base.multi_thread.thread;

import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * CountLatchDown 测试
 * 场景如下：
 *  1. 共有10个人参加跑步比赛，比赛结束后，记录每个参赛者的成绩
 */
public class CountLatchDownTest {

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();
        System.out.println("执行开始=============>" + start);

        // 百米赛跑：
        double total = 100;

        // 计数器：10
        CountDownLatch latch = new CountDownLatch(10);

        // 10个开始跑步，每个人的速度在（5, 10）之间
        for (int i=1; i<=10; i++) {
            // 每个人的速度，随机值
            Random random = new Random();
            double speed = (random.nextDouble() + 1) * 5;

            // 开始跑
            new Thread(new Runner(speed, total, latch), "参赛者"+i).start();

        }

        // 等待所有人跑完
        latch.await();

        // 所有人跑完了
        System.out.println("==================比赛结束==========================");

        System.out.println("==================裁判太累了，去蒸桑拿、抽烟喽，嘿嘿嘿==========================");

        long end = System.currentTimeMillis();
        System.out.println("执行结束=============>" + end);
        long time = end - start;

        System.out.println("总时长=============>" + (float)time/1000);


    }

}

class Runner implements Runnable {

    // 平均速度
    private double speed;
    // 总路程
    private double total;
    // 计数器
    private CountDownLatch latch;

    public Runner(double speed, double total, CountDownLatch latch) {
        this.speed = speed;
        this.total = total;
        this.latch = latch;
    }

    @Override
    public void run() {
        // 计算出总时长
        double time = total/speed;
        // 当前线程睡眠总时长的时间
        try {
            Thread.sleep((long)(time*1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("百米赛跑, " + Thread.currentThread().getName() + " 跑了： " + time + " 秒，速度是：" + speed + " m/s");
        latch.countDown();
//        System.out.println("此时，还有：" + latch.getCount() + " 个人未完成比赛");
//        System.out.println("===================================================>>>");
    }

}
