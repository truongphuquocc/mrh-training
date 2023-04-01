package com.tpq.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tpq.dto.BookDTO;
import com.tpq.service.BookServiceImpl;
import com.tpq.service.CommonService;

/**
 * Servlet implementation class BookController
 */
@WebServlet("/BookController")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CommonService<BookDTO> bookService;

	public void init() {
		this.bookService = new BookServiceImpl();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookController() {
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
				RequestDispatcher dispatcher = request.getRequestDispatcher("./view/book/create.jsp");
				dispatcher.forward(request, response);
				break;
			case "insert":
				String name = request.getParameter("name");
				int quantity = Integer.parseInt(request.getParameter("quantity"));
				int totalpage = Integer.parseInt(request.getParameter("totalpage"));
				String type = request.getParameter("type");
				BookDTO newbook = new BookDTO(name, totalpage, type, quantity);

				this.bookService.add(newbook);
				response.sendRedirect("book");
				break;
			case "delete":
				this.delete(request, response);
				break;
			case "edit":
				this.showEditForm(request, response);
				break;
			case "update":
				this.update(request, response);
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
		ArrayList<BookDTO> listbook = this.bookService.list();
		request.setAttribute("listbook", listbook);
		RequestDispatcher dispatcher = request.getRequestDispatcher("./view/book/index.jsp");
		dispatcher.forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int totalpage = Integer.parseInt(request.getParameter("totalpage"));
		String type = request.getParameter("type");
		BookDTO newbook = new BookDTO(id,name, totalpage, type, quantity);
		this.bookService.update(newbook);
		response.sendRedirect("book");
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		this.bookService.delete(id);
		response.sendRedirect("book");
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		BookDTO existingbook = this.bookService.get(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("./view/book/create.jsp");
		request.setAttribute("book", existingbook);
		dispatcher.forward(request, response);
	}

}
