package com.revature.pojos;

public class AcctType {
	
	private int typeId;
	private String typeName;


	public AcctType(){}
	
	public AcctType(String typeName){
		this.typeName = typeName;
		}

	@Override
	public String toString() {
		return "AcctType [typeId=" + typeId + ", typeName=" + typeName + "]";
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	

}
	
	