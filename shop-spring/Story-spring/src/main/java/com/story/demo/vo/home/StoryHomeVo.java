package com.story.demo.vo.home;

import java.sql.Date;

public class StoryHomeVo {
	private int no;
	private String title;
	private String contents;
	private Date regDate;
	
	public void setNo(int no) {
		this.no = no;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getNo() {
		return no;
	}
	public String getTitle() {
		return title;
	}
	public String getContents() {
		return contents;
	}
	public Date getRegDate() {
		return regDate;
	}
	
	@Override
	public String toString() {
		return "StoryHomeVo [no=" + no + ", title=" + title + ", contents=" + contents + ", regDate=" + regDate
				+ ", getNo()=" + getNo() + ", getTitle()=" + getTitle() + ", getContents()=" + getContents()
				+ ", getRegDate()=" + getRegDate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
