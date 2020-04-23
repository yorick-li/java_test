package org.design_pattern.observer_pattern.scene1;

/**
 * 侦探：观察者
 * @author hspcadmin
 *
 */
public class Detective implements Search, Notice {
	
	/**
	 * 被观察者
	 */
	private Husband husband;
	/**
	 * 通知的目标
	 */
	private Wife wife;

	public void search(Husband husband, Wife wife) {
		this.husband = husband;
		this.wife = wife;
	}
	
	public void process() {
		// 1. 查找证据
		Info info = husband.detrail(new Woman("莉莉"));
		// 2. 通知wife
		if (info.isChuGui()) {
			notice(info, wife);
		}else {
			notice(info, wife);
		}
	}

	public <T> void notice(Info info, Wife w) {
		System.out.println("侦探 发给 妻子的消息：" + info.getMessage());
		w.setInfo(info);
	}

}
