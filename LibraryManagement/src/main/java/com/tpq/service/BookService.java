package com.tpq.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.tpq.dto.BookDTO;

public class BookService implements CommonService<BookDTO> {

	@Override
	public ArrayList<BookDTO> list() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(BookDTO data) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(BookDTO data) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BookDTO get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int inUsed(int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
