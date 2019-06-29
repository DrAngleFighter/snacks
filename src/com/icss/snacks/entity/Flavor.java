package com.icss.snacks.entity;

/**
 * 
 * @author zly
 *
 */
public class Flavor {

	private Integer fid;
	private String fname;
	
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	@Override
	public String toString() {
		return "Flavor [fid=" + fid + ", fname=" + fname + "]";
	}
	
}
