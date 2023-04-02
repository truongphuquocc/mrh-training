package com.tpq.service;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BorrowService<T> {
	ArrayList<T> list(String searchValue, String fromDay, String toDay) throws SQLException;

	boolean add(T data) throws SQLException;
	
	boolean updateAmount(int id, int amount) throws SQLException;
}
