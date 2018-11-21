package com.ex.pojos;

public class ReimbursementEntry {
	
	private int reimbId;
	private double amount;
	private String timeSubmitted ;
	private String timeResolved;
	private String desc;
	private int userId;
	private int resolverId;
	private int statusId;
	private int reimbTypeId;
	
	public ReimbursementEntry() {};
	
	public ReimbursementEntry(
			int reimbId,
			double amount,
			String timeSubmitted,
			String timeResolved,
			String desc,
			int userId,
			int resolverId,
			int statusId,
			int reimbTypeId
	)
	{
		this.reimbId = reimbId;
		this.amount = amount;
		this.timeSubmitted = timeSubmitted;
		this.timeResolved = timeResolved;
		this.desc = desc;
		this.userId = userId;
		this.resolverId = resolverId;
		this.statusId = statusId;
		this.reimbTypeId = reimbTypeId;
	}
	
	@Override
	public String toString() {
		return "ReimbursementEntry [reimbId=" + reimbId + ", amount=" + amount + ", timeSubmitted=" + timeSubmitted
				+ ", timeResolved=" + timeResolved + ", desc=" + desc + ", userId=" + userId + ", resolverId="
				+ resolverId + ", statusId=" + statusId + ", reimbTypeId=" + reimbTypeId + "]";
	}

	public int getReimbId() {
		return reimbId;
	}
	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTimeSubmitted() {
		return timeSubmitted;
	}
	public void setTimeSubmitted(String timeSubmitted) {
		this.timeSubmitted = timeSubmitted;
	}
	public String getTimeResolved() {
		return timeResolved;
	}
	public void setTimeResolved(String timeResolved) {
		this.timeResolved = timeResolved;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getResolverId() {
		return resolverId;
	}
	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public int getReimbTypeId() {
		return reimbTypeId;
	}
	public void setReimbTypeId(int reimbTypeId) {
		this.reimbTypeId = reimbTypeId;
	}
}
