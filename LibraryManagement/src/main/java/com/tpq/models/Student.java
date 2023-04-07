package com.tpq.models;

public class Student {
	private int StudentID;
	private String Name;
	private int Age;
	private boolean Gender;
	private int InUsed;

	/**
	 * 
	 */
	public Student() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param age
	 * @param gender
	 * @param inUsed
	 */
	public Student(String name, int age, boolean gender, int inUsed) {
		super();
		Name = name;
		Age = age;
		Gender = gender;
		InUsed = inUsed;
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

	/**
	 * @return the inUsed
	 */
	public int getInUsed() {
		return InUsed;
	}

	/**
	 * @param inUsed the inUsed to set
	 */
	public void setInUsed(int inUsed) {
		InUsed = inUsed;
	}

}
