package com.lectopia.tsop.dto;

public class LikeMusicDTO {
	private String memberId;
	private int fileId;
	public LikeMusicDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LikeMusicDTO(String memberId, int fileId) {
		super();
		this.memberId = memberId;
		this.fileId = fileId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	@Override
	public String toString() {
		return "LikeMusicDTO [memberId=" + memberId + ", fileId=" + fileId + "]";
	}
	
	
}
