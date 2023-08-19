package com.springboot.firstRESTapi.helloWorld;

public class HelloWorldBean {
	private String massage;

	public String getMassage() {
		return massage;
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}

	public HelloWorldBean(String massage) {
		super();
		this.massage = massage;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [massage=" + massage + "]";
	}
}
