package org.design_pattern.observer_pattern.scene1;

public class ObserverPatternTest {

	public static void main(String[] args) {
		
		// 情景1：
		// 1.1 开始委托侦探
		System.out.println("情景1：");
		Wife wife1 = new Wife();
		Husband husband1 = new Husband();
		husband1.setYouErXin(false);
		Detective detective1 = new Detective();
		wife1.delegate(detective1, husband1);
		// 1.2 侦探开始调查
		detective1.process();
		// 1.3 妻子表达情绪
		wife1.displayEmotion();
		
		System.out.println();
		System.out.println("======================我是隔离线======================");
		System.out.println();
		
		// 情景2：
		// 2.1 开始委托侦探
		System.out.println("情景2：");
		Wife wife2 = new Wife();
		Husband husband2 = new Husband();
		husband2.setYouErXin(true);
		Detective detective2 = new Detective();
		wife2.delegate(detective2, husband2);
		// 2.2 侦探开始调查
		detective2.process();
		// 2.3 妻子表达情绪
		wife2.displayEmotion();
		
	}
	
}
