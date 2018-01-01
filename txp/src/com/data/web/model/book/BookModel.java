package com.data.web.model.book;

import com.data.web.model.system.BaseModel;

/**
 * 书籍表
 * @author txp
 * @date 2017-10-29 上午12:06:04
 */
public class BookModel extends BaseModel{

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
