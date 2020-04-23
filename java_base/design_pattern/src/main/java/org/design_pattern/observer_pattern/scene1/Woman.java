package org.design_pattern.observer_pattern.scene1;

public class Woman {
	
	private String name;

	public Woman(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Woman [name=" + name + "]";
	}
	
}
