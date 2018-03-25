package com.data.web.model.syllabus;

import com.data.web.model.system.BaseModel;

/**
 * 课程表
 * @author txp
 * @date 2017-10-29 ����12:06:04
 */
public class SyllabusModel extends BaseModel{

	/**
	 * id
	 */
	private String id;
	
	/**
	 * 用户id
	 */
	private String userId;
	
	/**
	 * 课程表名
	 */
	private String  syllabusName;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSyllabusName() {
		return syllabusName;
	}

	public void setSyllabusName(String syllabusName) {
		this.syllabusName = syllabusName;
	}

}
