package com.tpq.dto;

public class BookDTO {
	private int BookID;
	private String Name;	
	private int TotalPage;
	private String Type;
	private int Quantity;
	/**
	 * 
	 */
	public BookDTO() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param bookID
	 * @param name
	 * @param totalPage
	 * @param type
	 * @param quantity
	 */
	public BookDTO(int bookID, String name, int totalPage, String type, int quantity) {
		BookID = bookID;
		Name = name;
		TotalPage = totalPage;
		Type = type;
		Quantity = quantity;
	}
	/**
	 * @param name
	 * @param totalPage
	 * @param type
	 * @param quantity
	 */
	public BookDTO(String name, int totalPage, String type, int quantity) {
		Name = name;
		TotalPage = totalPage;
		Type = type;
		Quantity = quantity;
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
	 * @return the name
	 */
	public String getName() {
		return Name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}
	/**
	 * @return the totalPage
	 */
	public int getTotalPage() {
		return TotalPage;
	}
	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(int totalPage) {
		TotalPage = totalPage;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return Type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		Type = type;
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
	
}
