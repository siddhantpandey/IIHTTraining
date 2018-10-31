package com.verizon.jhd.model.composition;

import javax.persistence.Embeddable;

@Embeddable
public class Identification {

	private String photoFileName;
	private String fingerPrintFileName;
	public Identification() {
		super();
	}
	public Identification(String photoFileName, String fingerPrintFileName) {
		super();
		this.photoFileName = photoFileName;
		this.fingerPrintFileName = fingerPrintFileName;
	}
	public String getPhotoFileName() {
		return photoFileName;
	}
	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}
	public String getFingerPrintFileName() {
		return fingerPrintFileName;
	}
	public void setFingerPrintFileName(String fingerPrintFileName) {
		this.fingerPrintFileName = fingerPrintFileName;
	}
	
	
}
