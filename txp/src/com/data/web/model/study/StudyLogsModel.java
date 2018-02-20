package com.data.web.model.study;

import com.data.web.model.system.BaseModel;

/**
 * 学习记录
 * @author txp
 * @date 2017-10-29 ����12:06:04
 */
public class StudyLogsModel extends BaseModel{

	/**
	 * 记录id
	 */
	private String id;
	
	/**
	 * 用户id
	 */
	private String userId;
	
	/**
	 * 标题
	 */
	private String  logTitle;

	/**
	 * 内容
	 */
	private String logContent;

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

	public String getLogTitle() {
		return logTitle;
	}

	public void setLogTitle(String logTitle) {
		this.logTitle = logTitle;
	}

	public String getLogContent() {
		return logContent;
	}

	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}
	
}
