package org.design_pattern.observer_pattern.scene1;

public class Wife {

	private String name;
	private Info info;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}
	
	public void delegate(Detective detective, Husband husband) {
		detective.search(husband, this);
	}
	
	public void displayEmotion() {
		System.out.println("妻子表达的情绪：" + toString());
	}

	@Override
	public String toString() {
		if (info.isChuGui()) {
			return "这个没良心的，敢背叛老娘，老娘去撕了他们！";
		}else {
			return "这个死鬼，给他胆子也不敢背叛老娘 ^V^";
		}
	}
	
}
