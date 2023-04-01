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
		return this.studentDAO.list();
	}

	@Override
	public boolean add(StudentDTO data) throws SQLException {
		return this.studentDAO.add(data);
	}

	@Override
	public boolean update(StudentDTO data) throws SQLException {
		// TODO Auto-generated method stub
		return studentDAO.update(data);
	}

	@Override
	public boolean delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		if(studentDAO.inUsed(id) > 0)
			return false;
		return this.studentDAO.delete(id);
	}

	@Override
	public StudentDTO get(int id) throws SQLException {
		return studentDAO.get(id);

	}

	@Override
	public int inUsed(int id) throws SQLException {
		// TODO Auto-generated method stub
		return this.studentDAO.inUsed(id);
	}
}
