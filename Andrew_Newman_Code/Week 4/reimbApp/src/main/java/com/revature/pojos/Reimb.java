package com.revature.pojos;

import java.sql.Date;

public class Reimb {
	private int rID;
	private int amount;
	private Date submitted;
	private Date resolved;
	private String desc;
	private int author;
	private int resolver;
	private int statusID;
	private int typeID;
	
	public Reimb() {}

	public Reimb(int amount, Date submitted, Date resolved, String desc, int author, int resolver, int statusID,
			int typeID) {
		super();
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.desc = desc;
		this.author = author;
		this.resolver = resolver;
		this.statusID = statusID;
		this.typeID = typeID;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Date submitted) {
		this.submitted = submitted;
	}

	public Date getResolved() {
		return resolved;
	}

	public void setResolved(Date resolved) {
		this.resolved = resolved;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public int getResolver() {
		return resolver;
	}

	public void setResolver(int resolver) {
		this.resolver = resolver;
	}

	public int getStatusID() {
		return statusID;
	}

	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	@Override
	public String toString() {
		return "Reimb [rID=" + rID + ", amount=" + amount + ", submitted=" + submitted + ", resolved=" + resolved
				+ ", desc=" + desc + ", author=" + author + ", resolver=" + resolver + ", statusID=" + statusID
				+ ", typeID=" + typeID + "]";
	}
	
	
	

}
