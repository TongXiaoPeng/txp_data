package com.data.web.model.user;

import com.data.web.model.system.BaseModel;

/**
 * �û���
 * @author txp
 * @date 2017-10-29 ����12:06:04
 */
public class UserModel extends BaseModel{

	/**
	 * �û�id
	 */
	private String userId;
	
	/**
	 * �û�����
	 */
	private String userName;
	
	/**
	 * �û�����
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
	
}
