package com.verizon.crimreg.model;

public class Criminal {

	private int cId;
	private String cName;
	private String cNature;
	private int cSentenceDur;
	
	public Criminal() {
		super();
	}

	public Criminal(int cId, String cName, String cNature, int cSentenceDur) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cNature = cNature;
		this.cSentenceDur = cSentenceDur;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcNature() {
		return cNature;
	}

	public void setcNature(String cNature) {
		this.cNature = cNature;
	}

	public int getcSentenceDur() {
		return cSentenceDur;
	}

	public void setcSentenceDur(int cSentenceDur) {
		this.cSentenceDur = cSentenceDur;
	}

	@Override
	public String toString() {
		return "Criminal [cId=" + cId + ", cName=" + cName + ", cNature=" + cNature + ", cSentenceDur=" + cSentenceDur
				+ "]";
	}
	
	
}
