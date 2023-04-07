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
import javax.servlet.http.HttpSession;
import com.tpq.dto.StudentDTO;
import com.tpq.models.Student;
import com.tpq.service.CommonService;
import com.tpq.service.StudentServiceImpl;
import com.tpq.utils.Convert;

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
  public StudentController() {}

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
    String action =
        request.getParameter("action") != null ? request.getParameter("action") : "none";
    try {
      switch (action) {
        case "new":
          RequestDispatcher dispatcher = request.getRequestDispatcher("./view/student/create.jsp");
          dispatcher.forward(request, response);
          break;
        case "insert":
          this.insert(request, response);
          break;
        case "delete":
          this.deleteStudent(request, response);
          break;
        case "edit":
          this.showEditForm(request, response);
          break;
        case "update":
          this.updateStudent(request, response);
          break;
        default:
          this.getListStudent(request, response);
          break;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

  private void getListStudent(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, ServletException, IOException {
    try {
      ArrayList<StudentDTO> listStudent = this.studentService.list();
      ArrayList<Student> studentModelList = new ArrayList<Student>();
      listStudent.forEach((student) -> {
        try {
          int inUsed = studentService.inUsed(student.getStudentID());
          Student studentModel = Convert.inusedStudent(student, inUsed);
          studentModelList.add(studentModel);
        } catch (SQLException e) {
          e.printStackTrace();
        }
      });
      request.setAttribute("listStudent", studentModelList);
      RequestDispatcher dispatcher = request.getRequestDispatcher("./view/student/Index.jsp");
      dispatcher.forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void updateStudent(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {
    int id = Integer.parseInt(request.getParameter("id"));
    String name = request.getParameter("name");
    int age = Integer.parseInt(request.getParameter("age"));
    String booleanGender = request.getParameter("gender");
    Boolean gender;
    if (booleanGender.equals("1"))
      gender = true;
    else
      gender = false;
    StudentDTO newStudent = new StudentDTO(id, name, age, gender);
    System.out.println("in4" + newStudent.getAge());
    this.studentService.update(newStudent);
    response.sendRedirect("student");
  }
  
  private void insert(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {
    String name = request.getParameter("name");
    int age = Integer.parseInt(request.getParameter("age"));
    String booleanGender = request.getParameter("gender");
    boolean gender;
    if (booleanGender.equals("1"))
      gender = true;
    else
      gender = false;
    StudentDTO newStudent = new StudentDTO(name, age, gender);
    this.studentService.add(newStudent);
    response.sendRedirect("student");
  }

  private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {
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
