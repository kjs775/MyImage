package com.lectopia.tsop.dto;

import java.util.Date;

public class MusicDTO {
	private int fileId;
	private String title;
	private String intro;
	private Date regDate;
	private int genreId;
	private boolean visibility;
	private boolean downloadAccept;
	public MusicDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MusicDTO(int fileId, String title, String intro, Date regDate, int genreId, boolean visibility,
			boolean downloadAccept) {
		super();
		this.fileId = fileId;
		this.title = title;
		this.intro = intro;
		this.regDate = regDate;
		this.genreId = genreId;
		this.visibility = visibility;
		this.downloadAccept = downloadAccept;
	}
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getGenreId() {
		return genreId;
	}
	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}
	public boolean isVisibility() {
		return visibility;
	}
	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}
	public boolean isDownloadAccept() {
		return downloadAccept;
	}
	public void setDownloadAccept(boolean downloadAccept) {
		this.downloadAccept = downloadAccept;
	}
	@Override
	public String toString() {
		return "Music [fileId=" + fileId + ", title=" + title + ", intro=" + intro + ", regDate=" + regDate
				+ ", genreId=" + genreId + ", visibility=" + visibility + ", downloadAccept=" + downloadAccept + "]";
	}
	
	
	
}
