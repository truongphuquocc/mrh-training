package com.tpq.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tpq.dto.BookDTO;
import com.tpq.dto.BorrowDTO;
import com.tpq.dto.StudentDTO;
import com.tpq.service.BookServiceImpl;
import com.tpq.service.BorrowService;
import com.tpq.service.BorrowServiceImpl;
import com.tpq.service.CommonService;
import com.tpq.service.StudentServiceImpl;

/**
 * Servlet implementation class BorrowController
 */
@WebServlet("/BorrowController")
public class BorrowController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BorrowService<BorrowDTO> borrowService;
	private CommonService<StudentDTO> studentService;
	private CommonService<BookDTO> bookService;

	public void init() {
		this.borrowService = new BorrowServiceImpl();
		this.studentService = new StudentServiceImpl();
		this.bookService = new BookServiceImpl();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BorrowController() {
		super();
		// TODO Auto-generated constructor stub
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
				this.showEdit(request, response);
				break;
			case "insert":
				int studentID = Integer.parseInt(request.getParameter("studentid"));
				int bookID = Integer.parseInt(request.getParameter("bookid"));
				int quantity = Integer.parseInt(request.getParameter("quantity"));
				long millis = System.currentTimeMillis();
				BookDTO bookDTO = new BookDTO();
				bookDTO = bookService.get(bookID);
				java.sql.Date date = new java.sql.Date(millis);
				BorrowDTO newBorrow = new BorrowDTO(studentID, bookID, date, quantity);
				if (bookDTO.getQuantity() > quantity)
					this.borrowService.add(newBorrow);
				response.sendRedirect("borrow");
				break;
			case "delete":
				break;
			case "edit":
				break;
			case "update":
				break;
			default:
				this.getList(request, response);
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

	private void getList(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String searchvalue = request.getParameter("searchvalue");
		searchvalue = "";
		String fromday = request.getParameter("fromday");
		String today = request.getParameter("today");
		ArrayList<BorrowDTO> listborrow = this.borrowService.list(searchvalue, fromday, today);
		request.setAttribute("listborrow", listborrow);
		RequestDispatcher dispatcher = request.getRequestDispatcher("./view/borrow/index.jsp");
		dispatcher.forward(request, response);
	}

	private void showEdit(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		ArrayList<StudentDTO> listStudent = this.studentService.list();
		request.setAttribute("listStudent", listStudent);
		ArrayList<BookDTO> listbook = this.bookService.list();
		request.setAttribute("listbook", listbook);
		RequestDispatcher dispatcher = request.getRequestDispatcher("./view/borrow/create.jsp");
		dispatcher.forward(request, response);
	}

}
