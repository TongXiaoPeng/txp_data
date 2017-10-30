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
	 * 创建人
	 */
	private String createName;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更改人
	 */
	private String updateName;
	/**
	 * 更改时间
	 */
	private Date updateTime;
	/**
	 * 是否删除   0:否 ,1:是
	 */
	private int isDeleted;
	/**
	 * 备注
	 */
	private String remark;
	
	public String getCreateName() {
		return createName;
	}
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUpdateName() {
		return updateName;
	}
	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
