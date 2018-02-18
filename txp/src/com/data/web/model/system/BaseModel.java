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
	 * ����ʱ��
	 */
	private Date created;
	/**
	 * ����ʱ��
	 */
	private Date modified;
	/**
	 * �Ƿ�ɾ��   0:�� ,1:��
	 */
	private int isDelete;
	/**
	 * ��ע
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
