package com.yorick.pro_java_test.java_base.multi_thread.thread;

/**
 * 锁的重入测试
 * 目的：
 * 	搞清楚，重入锁，锁的引用对象是谁
 * 疑问：
 * 	锁的Son、Father对象的引用？还是锁的Son对象的引用？
 * 测试结果：
 * 	I'm son
 *	I'm father
 *	
 * 总结：
 * 	根据结果分析，是：
 * 	
 * @author hspcadmin
 *
 */
public class ReentryTest {
	public static void main(String[] args) {
		Son son = new Son();
		son.doSomething();
	}
}

class Father {
	/**
	 * 同步块
	 */
	public synchronized void doSomething() {
		System.out.println("I'm father");
	}
}

class Son extends Father {
	/**
	 * 同步块
	 */
	@Override
	public synchronized void doSomething() {
		System.out.println("I'm son");
		super.doSomething();
	}
}
