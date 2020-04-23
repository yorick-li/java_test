package com.yorick.pro_java_test.java_base.multi_thread.thread;

import java.util.Random;

/**
 * 生产者、消费者（多线程问题测试）
 */
public class ProducerAndConsumerTest {

    public static void main(String[] args) {

        /**
         * 包子数量，最多生产100个
         * 生产机器共有：3台，每台机器的速度是：2分钟10个包子
         * 生产模式如下：
         * 包子蓝中有30个包子后，开始起卖，包子数最多100个；
         * 包子数量大于50时，生产机器只启动1个；
         * 包子数量小于40时，启动2个机器，超过：70，生产机器只启动一个
         */
        int num = 0;



    }

}

/**
 * 生产者
 */
class Producer implements Runnable {

    private volatile Integer num;

    public Producer(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        if (num == 100) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized (num) {
            try {
                Thread.sleep(60 * 1000);
                num += 10;
                System.out.println("机器生产了：10个包子，目前存货还有：" + num + " 个包子");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

/**
 * 消费者
 */
class Consumer implements Runnable {

    private volatile Integer num;

    public Consumer(Integer num) {
        this.num = num;
    }

    @Override
    public void run() {
        if (num == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Random random = new Random();
        double i = random.nextDouble();
        synchronized (num) {
            try {
                Thread.sleep((long)(i * 1000));
                int out = (int)(i*10);
                num -= out;
                System.out.println("店里卖出了：" + out + "个包子，目前存货还有：" + num + " 个包子");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
