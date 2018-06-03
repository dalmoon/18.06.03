package com.springapp.vo;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class BoardVO {
	private int seq; //�۹�ȣ
	
	@NotBlank(message="������ �Է�")     
	private String title;	
	@NotEmpty(message="������ �Է�")      
	private String content;
	@NotBlank(message="�ۼ��ڸ� �Է�")
	private String writer;
	private String regdate;
	private int hitcount;
	@Size(min=2,max=6,message="2-6�� ���� ��й�ȣ �Է�")
	private String password;
	private int bref;
	private int bstep;
	private int blevel;
	private String uploadPath;
	private MultipartFile mfile; //���� �Ӽ�
	
	
	
	public String getUploadPath() {
		return uploadPath;
	}
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	
	public MultipartFile getMfile() {
		return mfile;
	}
	public void setMfile(MultipartFile mfile) {
		this.mfile = mfile;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getHitcount() {
		return hitcount;
	}
	public void setHitcount(int hitcount) {
		this.hitcount = hitcount;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public int getBref() {
		return bref;
	}
	public void setBref(int bref) {
		this.bref = bref;
	}
	public int getBstep() {
		return bstep;
	}
	public void setBstep(int bstep) {
		this.bstep = bstep;
	}
	public int getBlevel() {
		return blevel;
	}
	public void setBlevel(int blevel) {
		this.blevel = blevel;
	}
	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", title=" + title + ", content="
				+ content + ", writer=" + writer + ", regdate=" + regdate
				+ ", hitcount=" + hitcount + ", password=" + password
				+ ", bref=" + bref + ", bstep=" + bstep + ", blevel=" + blevel
				+ ", uploadPath=" + uploadPath + ", mfile=" + mfile + "]";
	}
	
	
	
	
}
