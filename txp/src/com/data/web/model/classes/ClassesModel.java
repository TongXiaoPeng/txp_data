package com.data.web.model.classes;

import com.data.web.model.system.BaseModel;

/**
 * �༶��
 * @author txp
 * @date 2017-10-29 ����12:06:04
 */
public class ClassesModel extends BaseModel{

	/**
	 * �༶id
	 */
	private String id;
	
	/**
	 * �༶����
	 */
	private String className;
	
	/**
	 * �༶�ȼ�
	 */
	private Integer  classLevel;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getClassLevel() {
		return classLevel;
	}

	public void setClassLevel(Integer classLevel) {
		this.classLevel = classLevel;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
