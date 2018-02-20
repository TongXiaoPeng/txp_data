package com.data.web.model.user;

import com.data.web.model.system.BaseModel;

/**
 * 用户
 * @author txp
 * @date 2017-10-29 ����12:06:04
 */
public class UserModel extends BaseModel{

	/**
	 * 用户id
	 */
	private String id;
	
	/**
	 * 用户名称
	 */
	private String userName;
	
	/**
	 * 用户类型 0：学生；1：老师
	 */
	private Integer roleType;
	
	/**
	 * 班级id
	 */
	private String classId;
	
	/**
	 * 密码
	 */
	private String passWord;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public Integer getRoleType() {
		return roleType;
	}

	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
}
