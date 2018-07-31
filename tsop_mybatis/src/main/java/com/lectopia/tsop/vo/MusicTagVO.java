package com.lectopia.tsop.vo;

public class MusicTagVO {
	private int fileid;
	private String tagName;
	public MusicTagVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MusicTagVO(int fileid, String tagName) {
		super();
		this.fileid = fileid;
		this.tagName = tagName;
	}
	public int getFileid() {
		return fileid;
	}
	public void setFileid(int fileid) {
		this.fileid = fileid;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	@Override
	public String toString() {
		return "MusicTagVO [fileid=" + fileid + ", tagName=" + tagName + "]";
	}
	
	
}
