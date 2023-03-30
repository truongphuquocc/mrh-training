package com.tpq.controller;

import java.io.IOException;
import java.sql.SQLException;

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
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			this.showEditForm(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("11111111111111111"+studentService);
		
		StudentDTO existingStudent = this.studentService.get(2);
		System.out.println("22222222222"+existingStudent);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("./view/student/Index.jsp");
		request.setAttribute("student", existingStudent);
		dispatcher.forward(request, response);
	}

}
