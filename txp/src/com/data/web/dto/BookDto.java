package com.data.web.dto;

import com.data.web.model.system.BaseModel;

/**
 * �鼮
 * @author txp
 * @date 2017-10-29 ����12:06:04
 */
public class BookDto extends BaseModel{

	/**
	 * �鼮id
	 */
	private String bookId;
	
	/**
	 * �û�id
	 */
	private String userId;
	
	/**
	 * �鼮����
	 */
	private String  bookName;
	
	/**
	 * �鼮����
	 */
	private String bookType;

	/**
	 * ��������
	 */
	private String borrowType;
	
	private String userName;
	
	private String phoneNumber;
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	public String getBorrowType() {
		return borrowType;
	}

	public void setBorrowType(String borrowType) {
		this.borrowType = borrowType;
	}

}
