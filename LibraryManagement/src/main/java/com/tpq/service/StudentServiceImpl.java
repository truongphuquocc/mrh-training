package com.tpq.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.eclipse.jdt.internal.compiler.batch.Main;

import com.tpq.dao.CommonDAO;
import com.tpq.dao.StudentDAOImpl;
import com.tpq.dto.StudentDTO;

public class StudentServiceImpl implements CommonService<StudentDTO> {

	private CommonDAO<StudentDTO> studentDAO;


	//studentDAO = new StudentDAOImpl();

	public StudentServiceImpl() {
		this.studentDAO = new StudentDAOImpl();
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
		return studentDAO.get(id);

	}
}
