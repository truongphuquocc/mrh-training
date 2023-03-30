package com.tpq.dto;

import java.util.Date;

public class BorrowDTO {
	public int BorrowID;
	public int StudentID;
	public int BookID;
	public int Quantity;
	public Date BorrowDate;
	/**
	 * 
	 */
	public BorrowDTO() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param studentID
	 * @param bookID
	 * @param quantity
	 * @param borrowDate
	 */
	public BorrowDTO(int studentID, int bookID, int quantity, Date borrowDate) {
		StudentID = studentID;
		BookID = bookID;
		Quantity = quantity;
		BorrowDate = borrowDate;
	}
	/**
	 * @param borrowID
	 * @param studentID
	 * @param bookID
	 * @param quantity
	 * @param borrowDate
	 */
	public BorrowDTO(int borrowID, int studentID, int bookID, int quantity, Date borrowDate) {
		BorrowID = borrowID;
		StudentID = studentID;
		BookID = bookID;
		Quantity = quantity;
		BorrowDate = borrowDate;
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
