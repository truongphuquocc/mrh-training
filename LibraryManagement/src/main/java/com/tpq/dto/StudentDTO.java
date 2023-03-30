package com.tpq.dto;

public class StudentDTO {
	private int StudentID;
	private String Name;
	private int Age;
	private boolean Gender;

	/**
	 * @param name
	 * @param age
	 * @param gender
	 */
	public StudentDTO(String name, int age, boolean gender) {
		Name = name;
		Age = age;
		Gender = gender;
	}

	/**
	 * @param studentID
	 * @param name
	 * @param age
	 * @param gender
	 */
	public StudentDTO(int studentID, String name, int age, boolean gender) {
		StudentID = studentID;
		Name = name;
		Age = age;
		Gender = gender;
	}

	/**
	 * 
	 */
	public StudentDTO() {
		// TODO Auto-generated constructor stub
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
	 * @return the age
	 */
	public int getAge() {
		return Age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		Age = age;
	}

	/**
	 * @return the gender
	 */
	public boolean isGender() {
		return Gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(boolean gender) {
		Gender = gender;
	}


}
