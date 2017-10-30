package com.data.web.model.system;

import java.util.Date;

import javax.persistence.MappedSuperclass;

/**
 * ����model
 * @author txp
 * @date 2017-10-29 ����12:01:43
 */
@MappedSuperclass
public class BaseModel {

	/**
	 * ������
	 */
	private String createName;
	/**
	 * ����ʱ��
	 */
	private Date createTime;
	/**
	 * ������
	 */
	private String updateName;
	/**
	 * ����ʱ��
	 */
	private Date updateTime;
	/**
	 * �Ƿ�ɾ��   0:�� ,1:��
	 */
	private int isDeleted;
	/**
	 * ��ע
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
