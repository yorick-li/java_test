package org.design_pattern.observer_pattern.scene1;

/**
 * 丈夫：被观察者
 * @author hspcadmin
 *
 */
public class Husband implements Derailment {
	
	private boolean youErXin;
	
	public boolean isYouErXin() {
		return youErXin;
	}

	public void setYouErXin(boolean youErXin) {
		this.youErXin = youErXin;
	}

	public Info detrail(Woman woman) {
		if (youErXin) {
			return new Info(true, "和" + woman.getName() + "一起玩耍很开心");
		}else {
			return new Info(false, "要和老婆大人生生世世在一起");
		}
		
	}

}
