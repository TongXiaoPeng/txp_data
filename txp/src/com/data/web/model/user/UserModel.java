package com.data.web.model.user;

import com.data.web.model.system.BaseModel;

/**
 * 用户表
 * @author txp
 * @date 2017-10-29 上午12:06:04
 */
public class UserModel extends BaseModel{

	/**
	 * 用户id
	 */
	private String userId;
	
	/**
	 * 用户名称
	 */
	private String userName;
	
	private String  phoneNumber;
	
	/**
	 * 用户密码
	 */
	private String passWord;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
