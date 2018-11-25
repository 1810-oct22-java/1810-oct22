package com.revature.pojo;

public class StatusChange {
	private int status;
	private int id;
	
	public StatusChange() {}
	
	public StatusChange(int status, int id) {
		super();
		this.status = status;
		this.id = id;
	}



	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "StatusChange [status=" + status + ", id=" + id + "]";
	}
}
