package com.tpq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tpq.dto.StudentDTO;

public class StudentDAOImpl extends MySqlCon implements CommonDAO<StudentDTO> {
  private Connection jdbcConnection;


  public StudentDAOImpl() {

  }

  @Override
  public ArrayList<StudentDTO> list() throws SQLException {
    ArrayList<StudentDTO> listProd = new ArrayList<StudentDTO>();

    String sql = "SELECT * FROM students";

    jdbcConnection = MySqlCon.connectDb();

    Statement statement = jdbcConnection.createStatement();
    ResultSet resultSet = statement.executeQuery(sql);

    while (resultSet.next()) {
      int id = resultSet.getInt("StudentID");
      String name = resultSet.getString("Name");
      int age = resultSet.getInt("Age");
      Boolean gender = resultSet.getBoolean("Gender");
      StudentDTO product = new StudentDTO(id, name, age, gender);
      listProd.add(product);
    }

    resultSet.close();
    statement.close();

    MySqlCon.disconnect(jdbcConnection);

    return listProd;
  }

  @Override
  public boolean add(StudentDTO data) throws SQLException {
    String sqlInsert = "insert into Students (Name,Age,Gender) values(?,?,?);";
    jdbcConnection = MySqlCon.connectDb();
    PreparedStatement statement = jdbcConnection.prepareStatement(sqlInsert);
    statement.setString(1, data.getName());
    statement.setInt(2, data.getAge());
    statement.setBoolean(3, data.isGender());

    boolean rowInserted = statement.executeUpdate() > 0;
    statement.close();
    MySqlCon.disconnect(jdbcConnection);
    return rowInserted;
  }

  @Override
  public boolean update(StudentDTO data) throws SQLException {
    String sql = "UPDATE students SET Name = ?, Age = ?, Gender = ?  WHERE StudentID = ?";
    jdbcConnection = MySqlCon.connectDb();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    statement.setString(1, data.getName());
    statement.setInt(2, data.getAge());
    statement.setBoolean(3, data.isGender());
    statement.setInt(4, data.getStudentID());

    boolean rowUpdated = statement.executeUpdate() > 0;
    statement.close();
    MySqlCon.disconnect(jdbcConnection);
    return rowUpdated;
  }

  @Override
  public boolean delete(int id) throws SQLException {
    String sql = "DELETE FROM students where StudentID = ?";

    jdbcConnection = MySqlCon.connectDb();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    statement.setInt(1, id);

    boolean rowDeleted = statement.executeUpdate() > 0;
    statement.close();
    MySqlCon.disconnect(jdbcConnection);
    return rowDeleted;
  }

  @Override
  public StudentDTO get(int id) throws SQLException {
    StudentDTO stu = null;
    String sql = "SELECT * FROM students WHERE StudentID = ?";

    jdbcConnection = MySqlCon.connectDb();

    PreparedStatement statement = connectDb().prepareStatement(sql);
    statement.setInt(1, id);

    ResultSet resultSet = statement.executeQuery();

    if (resultSet.next()) {
      id = resultSet.getInt("StudentID");
      String name = resultSet.getString("name");
      int age = resultSet.getInt("age");
      boolean gender = resultSet.getBoolean("gender");
      stu = new StudentDTO(id, name, age, gender);
    }
    resultSet.close();
    statement.close();
    MySqlCon.disconnect(jdbcConnection);
    return stu;
  }

  @Override
  public int inUsed(int id) throws SQLException {
    String sql = "SELECT COUNT(StudentID) AS Isdisabe FROM Borrows where StudentID = ?;";

    jdbcConnection = MySqlCon.connectDb();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    statement.setInt(1, id);

    ResultSet result = statement.executeQuery();
    while (result.next()) {
      return (int) result.getInt(1);
    }


    statement.close();
    MySqlCon.disconnect(jdbcConnection);
    return -1;
  }

  public static void main(String[] args) {
    StudentDTO stuDTO = new StudentDTO(1, "Nguyen Thi Huyen", 20, false);
    StudentDAOImpl stuDAOImpl = new StudentDAOImpl();
    try {
      stuDAOImpl.inUsed(122);
      System.out.println(stuDAOImpl.inUsed(122));
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
