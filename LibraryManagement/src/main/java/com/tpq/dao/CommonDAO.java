package com.tpq.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CommonDAO<T> {
	ArrayList<T> list() throws SQLException;

	boolean add(T data) throws SQLException;

	boolean update(T data) throws SQLException;

	boolean delete(T data) throws SQLException;

	T get(int id) throws SQLException;
}
