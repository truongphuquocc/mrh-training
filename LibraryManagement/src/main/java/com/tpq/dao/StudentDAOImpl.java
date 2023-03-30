package com.tpq.dao;

import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tpq.dto.StudentDTO;

public class StudentDAOImpl extends MySqlCon implements CommonDAO<StudentDTO> {
	private Connection jdbcConnection;

	
	public StudentDAOImpl() {
		
	}
	
	@Override
	public ArrayList<StudentDTO> list() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(StudentDTO data) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(StudentDTO data) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(StudentDTO data) throws SQLException {
		// TODO Auto-generated method stub
		return false;
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
			String name = resultSet.getString("name");
			int age = resultSet.getInt("age");
			boolean gender = resultSet.getBoolean("gender");
			stu = new StudentDTO(name, age, gender);
		}

		resultSet.close();
		statement.close();
		MySqlCon.disconnect(jdbcConnection);
		return stu;
	}

}
