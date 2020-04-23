package org.design_pattern.observer_pattern.scene1;

public class Info {
	
	private boolean chuGui;
	private String message;
	
	public Info(boolean chuGui, String message) {
		super();
		this.chuGui = chuGui;
		this.message = message;
	}

	public boolean isChuGui() {
		return chuGui;
	}

	public void setChuGui(boolean chuGui) {
		this.chuGui = chuGui;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Info [chuGui=" + chuGui + ", message=" + message + "]";
	}

}
