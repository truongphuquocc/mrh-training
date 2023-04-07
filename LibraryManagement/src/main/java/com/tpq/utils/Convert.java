package com.tpq.utils;

import java.text.SimpleDateFormat;

import com.tpq.dto.BookDTO;
import com.tpq.dto.StudentDTO;
import com.tpq.models.Book;
import com.tpq.models.Student;

public class Convert {
	public static boolean isValidDate(String inDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(inDate.trim());
		} catch (Exception pe) {
			return false;
		}
		return true;
	}
	
	public static Book inUsedBook(BookDTO bookDTO, int inUsed) {
		Book bookModel = new Book();
		bookModel.setBookID(bookDTO.getBookID());
		bookModel.setName(bookDTO.getName());
		bookModel.setQuantity(bookDTO.getQuantity());
		bookModel.setType(bookDTO.getType());
		bookModel.setTotalPage(bookDTO.getTotalPage());
		bookModel.setInUsed(inUsed);
		
		return bookModel;
	}
	
	public static Student inusedStudent(StudentDTO studentDTO, int inUsed) {
		Student studentModel = new Student();
		studentModel.setStudentID(studentDTO.getStudentID());
		studentModel.setName(studentDTO.getName());
		studentModel.setAge(studentDTO.getAge());
		studentModel.setGender(studentDTO.isGender());
		studentModel.setInUsed(inUsed);
		
		return studentModel;
	}
}
