package com.tpq.dto;

import java.util.Date;

public class BorrowDTO {
	public int BorrowID;
	public int StudentID;
	public String StudentName;
	public int BookID;
	public String BookName;
	public int Quantity;
	public Date BorrowDate;
	/**
	 * 
	 */
	public BorrowDTO() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param borrowID
	 * @param studentID
	 * @param studentName
	 * @param bookID
	 * @param bookName
	 * @param quantity
	 * @param borrowDate
	 */
	public BorrowDTO(int borrowID, int studentID, String studentName, int bookID, String bookName, int quantity,
			Date borrowDate) {
		super();
		BorrowID = borrowID;
		StudentID = studentID;
		StudentName = studentName;
		BookID = bookID;
		BookName = bookName;
		Quantity = quantity;
		BorrowDate = borrowDate;
	}
	/**
	 * @param studentID
	 * @param studentName
	 * @param bookID
	 * @param bookName
	 * @param quantity
	 * @param borrowDate
	 */
	public BorrowDTO(int studentID, String studentName, int bookID, String bookName, int quantity, Date borrowDate) {
		super();
		StudentID = studentID;
		StudentName = studentName;
		BookID = bookID;
		BookName = bookName;
		Quantity = quantity;
		BorrowDate = borrowDate;
	}
	
	
	/**
	 * @param studentID
	 * @param bookID
	 * @param borrowDate
	 */
	public BorrowDTO(int studentID, int bookID, Date borrowDate, int quantity) {
		super();
		StudentID = studentID;
		BookID = bookID;
		BorrowDate = borrowDate;
		Quantity = quantity;
	}
	/**
	 * @return the borrowID
	 */
	public int getBorrowID() {
		return BorrowID;
	}
	/**
	 * @param borrowID the borrowID to set
	 */
	public void setBorrowID(int borrowID) {
		BorrowID = borrowID;
	}
	/**
	 * @return the studentID
	 */
	public int getStudentID() {
		return StudentID;
	}
	/**
	 * @param studentID the studentID to set
	 */
	public void setStudentID(int studentID) {
		StudentID = studentID;
	}
	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return StudentName;
	}
	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	/**
	 * @return the bookID
	 */
	public int getBookID() {
		return BookID;
	}
	/**
	 * @param bookID the bookID to set
	 */
	public void setBookID(int bookID) {
		BookID = bookID;
	}
	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return BookName;
	}
	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return Quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	/**
	 * @return the borrowDate
	 */
	public Date getBorrowDate() {
		return BorrowDate;
	}
	/**
	 * @param borrowDate the borrowDate to set
	 */
	public void setBorrowDate(Date borrowDate) {
		BorrowDate = borrowDate;
	}



}
