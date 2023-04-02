package com.tpq.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BorrowDAO<T> {
	ArrayList<T> list(String searchValue, String fromDay, String Today) throws SQLException;

	boolean add(T data) throws SQLException;
	
	boolean updateAnount(int id, int amount) throws SQLException;
}
