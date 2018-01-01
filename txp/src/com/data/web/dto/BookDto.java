package com.data.web.dto;

import com.data.web.model.system.BaseModel;

/**
 * 书籍
 * @author txp
 * @date 2017-10-29 上午12:06:04
 */
public class BookDto extends BaseModel{

	/**
	 * 书籍id
	 */
	private String bookId;
	
	/**
	 * 用户id
	 */
	private String userId;
	
	/**
	 * 书籍名称
	 */
	private String  bookName;
	
	/**
	 * 书籍类型
	 */
	private String bookType;

	/**
	 * 出借类型
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
