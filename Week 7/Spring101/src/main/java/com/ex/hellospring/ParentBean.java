package com.ex.hellospring;

public class ParentBean {
	
	private HelloWorld hello;
	
	public ParentBean() {}

	public ParentBean(HelloWorld hello) {
		super();
		this.hello = hello;
	}

	public HelloWorld getHello() {
		return hello;
	}

	public void setHello(HelloWorld hello) {
		this.hello = hello;
	}
	

}
