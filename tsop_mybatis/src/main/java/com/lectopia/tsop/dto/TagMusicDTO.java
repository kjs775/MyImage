package com.lectopia.tsop.dto;

public class TagMusicDTO {
	private String tagName;
	private int fileId;
	public TagMusicDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TagMusicDTO(String tagName, int fileId) {
		super();
		this.tagName = tagName;
		this.fileId = fileId;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	@Override
	public String toString() {
		return "TagMusicDTO [tagName=" + tagName + ", fileId=" + fileId + "]";
	}
	
	
}
