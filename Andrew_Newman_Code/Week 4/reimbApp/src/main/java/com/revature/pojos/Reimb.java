package com.revature.pojos;

import java.sql.Timestamp;

public class Reimb {
	private int rID;
	private int amount;
	private Timestamp submitted;
	private Timestamp resolved;
	private String desc;
	private int author;
	private int resolver;
	private int statusID;
	private int typeID;
	
	public Reimb() {}

	public Reimb(int amount, Timestamp submitted, String desc, int author, int statusID,int typeID) {
		super();
		this.amount = amount;
		this.submitted = submitted;
		this.desc = desc;
		this.author = author;
		this.statusID = statusID;
		this.typeID = typeID;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Timestamp getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Timestamp timestamp) {
		this.submitted = timestamp;
	}

	public Timestamp getResolved() {
		return resolved;
	}

	public void setResolved(Timestamp timestamp) {
		this.resolved = timestamp;
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

	public int getrID() {
		return rID;
	}

	public void setrID(int rID) {
		this.rID = rID;
	}

	@Override
	public String toString() {
		return "Reimb [rID=" + rID + ", amount=" + amount + ", submitted=" + submitted + ", resolved=" + resolved
				+ ", desc=" + desc + ", author=" + author + ", resolver=" + resolver + ", statusID=" + statusID
				+ ", typeID=" + typeID + "]";
	}

	
	
	

}
