package com.data.web.model.system;

import java.util.Date;

import javax.persistence.MappedSuperclass;

/**
 * 基础model
 * @author txp
 * @date 2017-10-29 上午12:01:43
 */
@MappedSuperclass
public class BaseModel {

	/**
	 * 创建时间
	 */
	private Date created;
	/**
	 * 更改时间
	 */
	private Date modified;
	/**
	 * 是否删除   0:否 ,1:是
	 */
	private int isDelete;
	/**
	 * 备注
	 */
	private String remark;
	
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	
}
