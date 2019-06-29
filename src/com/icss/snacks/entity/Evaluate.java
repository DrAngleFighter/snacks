package com.icss.snacks.entity;

import java.sql.Timestamp;

/**
 * 
 * @author zly
 *
 */
public class Evaluate {

	private Integer eid;
	private Integer uid;
	private String oid;
	private Timestamp createtime;
	private String content;
	
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Evaluate [eid=" + eid + ", uid=" + uid + ", oid=" + oid + ", createtime=" + createtime + ", content="
				+ content + "]";
	}
	
	
}
