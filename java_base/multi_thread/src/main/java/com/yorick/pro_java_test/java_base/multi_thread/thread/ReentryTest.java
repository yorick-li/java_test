package com.yorick.pro_java_test.java_base.multi_thread.thread;

/**
 * �����������
 * Ŀ�ģ�
 * 	����������������������ö�����˭
 * ���ʣ�
 * 	����Son��Father��������ã���������Son��������ã�
 * ���Խ����
 * 	I'm son
 *	I'm father
 *	
 * �ܽ᣺
 * 	���ݽ���������ǣ�
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
	 * ͬ����
	 */
	public synchronized void doSomething() {
		System.out.println("I'm father");
	}
}

class Son extends Father {
	/**
	 * ͬ����
	 */
	@Override
	public synchronized void doSomething() {
		System.out.println("I'm son");
		super.doSomething();
	}
}
