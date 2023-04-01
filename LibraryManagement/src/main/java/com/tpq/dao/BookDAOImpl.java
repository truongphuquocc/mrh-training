package com.tpq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tpq.dto.BookDTO;

public class BookDAOImpl implements CommonDAO<BookDTO> {
	private Connection jdbcConnection;
	
	
	public BookDAOImpl() {

	}

	@Override
	public ArrayList<BookDTO> list() throws SQLException {
		ArrayList<BookDTO> listProd = new ArrayList<BookDTO>();

		String sql = "SELECT * FROM books";

		jdbcConnection = MySqlCon.connectDb();

		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			int id = resultSet.getInt("BookID");
			String name = resultSet.getString("Name");
			int totalPage = resultSet.getInt("TotalPage");
			String type = resultSet.getString("Type");
			int quantity = resultSet.getInt("Quantity");
			BookDTO book = new BookDTO(id, name, totalPage, type, quantity);
			listProd.add(book);
		}

		resultSet.close();
		statement.close();

		MySqlCon.disconnect(jdbcConnection);

		return listProd;
	}

	@Override
	public boolean add(BookDTO data) throws SQLException {
		String sqlInsert = "insert into Books (Name,TotalPage,Quantity, Type) values(?,?,?,?);";
		jdbcConnection = MySqlCon.connectDb();
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlInsert);
		statement.setString(1, data.getName());
		statement.setInt(2, data.getTotalPage());
		statement.setInt(3, data.getQuantity());
		statement.setString(4, data.getType());
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		MySqlCon.disconnect(jdbcConnection);
		return rowInserted;
	}

	@Override
	public boolean update(BookDTO data) throws SQLException {
		String sql = "UPDATE books SET Name = ?, TotalPage = ?, Quantity = ?, Type = ?  WHERE BookID = ?";
		jdbcConnection = MySqlCon.connectDb();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, data.getName());
		statement.setInt(2, data.getTotalPage());
		statement.setInt(3, data.getQuantity());
		statement.setString(4, data.getType());
		statement.setInt(5, data.getBookID());
		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		MySqlCon.disconnect(jdbcConnection);
		return rowUpdated;
	}

	@Override
	public boolean delete(int id) throws SQLException {
		String sql = "DELETE FROM books where BookID = ?";

		jdbcConnection = MySqlCon.connectDb();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id);

		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		MySqlCon.disconnect(jdbcConnection);
		return rowDeleted;
	}

	@Override
	public BookDTO get(int id) throws SQLException {
		BookDTO stu = null;
		String sql = "SELECT * FROM books WHERE BookID = ?";

		jdbcConnection = MySqlCon.connectDb();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {
			id = resultSet.getInt("BookID");
			String name = resultSet.getString("Name");
			int totalPage = resultSet.getInt("TotalPage");
			String type = resultSet.getString("Type");
			int quantity = resultSet.getInt("Quantity");
			stu = new BookDTO(id, name, totalPage, type, quantity);
		}

		resultSet.close();
		statement.close();
		MySqlCon.disconnect(jdbcConnection);
		return stu;
	}

	@Override
	public int inUsed(int id) throws SQLException {
		String sql = "SELECT COUNT(BookID) AS Isdisabe FROM Borrows where BookID = ?;";

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

}
