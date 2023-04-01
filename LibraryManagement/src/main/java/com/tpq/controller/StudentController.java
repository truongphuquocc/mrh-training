package com.tpq.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tpq.dto.StudentDTO;
import com.tpq.service.CommonService;
import com.tpq.service.StudentServiceImpl;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CommonService<StudentDTO> studentService;

	public void init() {
		this.studentService = new StudentServiceImpl();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentController() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("action") != null ? request.getParameter("action") : "none";
		try {
			switch (action) {
			case "new":
				RequestDispatcher dispatcher = request.getRequestDispatcher("./view/student/create.jsp");
				dispatcher.forward(request, response);
				break;
			case "insert":
				String name = request.getParameter("name");
				int age = Integer.parseInt(request.getParameter("age"));
				String booleanGender = request.getParameter("gender");
				boolean gender;
				if(booleanGender.equals("1"))
					gender = true;
				else 
					gender = false;

				StudentDTO newStudent = new StudentDTO(name, age, gender);
				this.studentService.add(newStudent);
				response.sendRedirect("student");
			case "delete":
				this.deleteStudent(request, response);
				break;
			case "edit":
				this.showEditForm(request, response);
				break;
			case "update":
				this.updateProduct(request, response);
				break;
			default:
				this.getListProduct(request, response);
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void getListProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		ArrayList<StudentDTO> listStudent = this.studentService.list();
		System.out.println("name"+listStudent);
		request.setAttribute("listStudent", listStudent);
		RequestDispatcher dispatcher = request.getRequestDispatcher("./view/student/Index.jsp");
		dispatcher.forward(request, response);
	}
	
	private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String booleanGender = request.getParameter("gender");
		Boolean gender;
		if(booleanGender.equals("1"))
			gender = true;
		else 
			gender = false;
		System.out.println("sua di22222");
		StudentDTO newStudent = new StudentDTO(id, name, age, gender);
		System.out.println("in4"+newStudent.getAge());
		this.studentService.update(newStudent);
		response.sendRedirect("student");
	}
	
	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		this.studentService.delete(id);
		response.sendRedirect("student");
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));	
		StudentDTO existingStudent = this.studentService.get(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("./view/student/create.jsp");
		request.setAttribute("student", existingStudent);
		dispatcher.forward(request, response);
	}

}
