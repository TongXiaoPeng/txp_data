package com.data.web.model.classes;

import com.data.web.model.system.BaseModel;

/**
 * 班级表
 * @author txp
 * @date 2017-10-29 上午12:06:04
 */
public class ClassesModel extends BaseModel{

	/**
	 * 班级id
	 */
	private String id;
	
	/**
	 * 班级名称
	 */
	private String className;
	
	/**
	 * 班级等级
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
