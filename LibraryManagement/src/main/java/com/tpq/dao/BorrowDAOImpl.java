package com.tpq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.tpq.dto.BorrowDTO;

public class BorrowDAOImpl implements BorrowDAO<BorrowDTO> {

	private Connection jdbcConnection;

	/**
	 * 
	 */
	public BorrowDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<BorrowDTO> list(String searchValue, String fromDay, String Today) throws SQLException {
		ArrayList<BorrowDTO> listProd = new ArrayList<BorrowDTO>();
//		if (searchValue != "")
//			searchValue = "%" + searchValue + "%";

		if (fromDay == "" && Today == "") {
			String sql = "SELECT br.BorrowID, bo.BookID, bo.Name AS BookName, br.BorrowDate, st.StudentID,\r\n"
					+ "       st.Name AS StudentName, br.Quantity \r\n"
					+ "from borrows as br left join books as bo on br.BookID = bo.BookID \r\n"
					+ "left join students as st on br.StudentID = st.StudentID \r\n"
					+ "where (st.StudentID like ? or st.Name like ?  or bo.BookID like ? or bo.Name like ?)";
			jdbcConnection = MySqlCon.connectDb();
			PreparedStatement statement = jdbcConnection.prepareStatement(sql);
			statement.setString(1, "%" + searchValue + "%");
			statement.setString(2, "%" + searchValue + "%");
			statement.setString(3, "%" + searchValue + "%");
			statement.setString(4, "%" + searchValue + "%");
			// statement.setString(5, searchValue);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int bookID = resultSet.getInt("BookID");
				String bookName = resultSet.getString("BookName");
				Date borrowDate = resultSet.getDate("BorrowDate");
				int studentID = resultSet.getInt("StudentID");
				String studentName = resultSet.getString("StudentName");
				int quantity = resultSet.getInt("Quantity");
				BorrowDTO borrow = new BorrowDTO(studentID, studentName, bookID, bookName, quantity, borrowDate);
				listProd.add(borrow);
			}
			resultSet.close();
			statement.close();
		} else if (fromDay != "" && Today == "") {
			String sql = "SELECT br.BorrowID, bo.BookID, bo.Name AS BookName, br.BorrowDate, st.StudentID,\r\n"
					+ "st.Name AS StudentName, br.Quantity\r\n"
					+ "from borrows as br left join books as bo on br.BookID = bo.BookID \r\n"
					+ "left join students as st on br.StudentID = st.StudentID \r\n"
					+ "where (st.StudentID like ? or st.Name like ?  or bo.BookID like ? or bo.Name like ?)\r\n"
					+ "and (br.BorrowDate = ? )";
			jdbcConnection = MySqlCon.connectDb();
			PreparedStatement statement = jdbcConnection.prepareStatement(sql);
			statement.setString(1, "%" + searchValue + "%");
			statement.setString(2, "%" + searchValue + "%");
			statement.setString(3, "%" + searchValue + "%");
			statement.setString(4, "%" + searchValue + "%");
			statement.setString(5, fromDay);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int bookID = resultSet.getInt("BookID");
				String bookName = resultSet.getString("BookName");
				Date borrowDate = resultSet.getDate("BorrowDate");
				int studentID = resultSet.getInt("StudentID");
				String studentName = resultSet.getString("StudentName");
				int quantity = resultSet.getInt("Quantity");
				BorrowDTO borrow = new BorrowDTO(studentID, studentName, bookID, bookName, quantity, borrowDate);
				listProd.add(borrow);
			}
			resultSet.close();
			statement.close();
		} else if (fromDay != "" && Today != "") {
			String sql = "SELECT br.BorrowID, bo.BookID, bo.Name AS BookName, br.BorrowDate, st.StudentID,\r\n"
					+ "       st.Name AS StudentName, br.Quantity\r\n"
					+ "from borrows as br left join books as bo on br.BookID = bo.BookID \r\n"
					+ "left join students as st on br.StudentID = st.StudentID \r\n"
					+ "where (st.StudentID like ? or st.Name like ?  or bo.BookID like ? or bo.Name like ?)\r\n"
					+ "and (br.BorrowDate between ? AND ?);	";
			jdbcConnection = MySqlCon.connectDb();
			PreparedStatement statement = jdbcConnection.prepareStatement(sql);
			statement.setString(1, "%" + searchValue + "%");
			statement.setString(2, "%" + searchValue + "%");
			statement.setString(3, "%" + searchValue + "%");
			statement.setString(4, "%" + searchValue + "%");
			statement.setString(5, fromDay);
			statement.setString(6, Today);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int bookID = resultSet.getInt("BookID");
				String bookName = resultSet.getString("BookName");
				Date borrowDate = resultSet.getDate("BorrowDate");
				int studentID = resultSet.getInt("StudentID");
				String studentName = resultSet.getString("StudentName");
				int quantity = resultSet.getInt("Quantity");
				BorrowDTO borrow = new BorrowDTO(studentID, studentName, bookID, bookName, quantity, borrowDate);
				listProd.add(borrow);
			}
			resultSet.close();
			statement.close();
		} 
		if (searchValue.matches("\\d{4}-\\d{2}-\\d{2}")) {
			String sql = "SELECT br.BorrowID, bo.BookID, bo.Name AS BookName, br.BorrowDate, st.StudentID,\r\n"
					+ "       st.Name AS StudentName, br.Quantity\r\n"
					+ "from borrows as br left join books as bo on br.BookID = bo.BookID \r\n"
					+ "left join students as st on br.StudentID = st.StudentID \r\n" + "where br.BorrowDate = ?;";
			jdbcConnection = MySqlCon.connectDb();
			PreparedStatement statement = jdbcConnection.prepareStatement(sql);
			statement.setString(1, searchValue);
			System.out.println("da vao day");
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int bookID = resultSet.getInt("BookID");
				String bookName = resultSet.getString("BookName");
				Date borrowDate = resultSet.getDate("BorrowDate");
				int studentID = resultSet.getInt("StudentID");
				String studentName = resultSet.getString("StudentName");
				int quantity = resultSet.getInt("Quantity");
				BorrowDTO borrow = new BorrowDTO(studentID, studentName, bookID, bookName, quantity, borrowDate);
				listProd.add(borrow);
			}
			resultSet.close();
			statement.close();
		}
		MySqlCon.disconnect(jdbcConnection);
		return listProd;
	}

	@Override
	public boolean add(BorrowDTO data) throws SQLException {
		String sqlInsert = "insert into Borrows(StudentID, BookID, BorrowDate, Quantity) values (?, ?, ?, ?)";
		jdbcConnection = MySqlCon.connectDb();
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlInsert);
		statement.setInt(1, data.getStudentID());
		statement.setInt(2, data.getBookID());
		statement.setDate(3, (java.sql.Date) data.getBorrowDate());
		statement.setInt(4, data.getQuantity());
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		MySqlCon.disconnect(jdbcConnection);
		return rowInserted;
	}

	@Override
	public boolean updateAnount(int id, int amount) throws SQLException {
		String sql = "UPDATE `bookstore`.`books` SET `Quantity` = `Quantity` - ? WHERE (`BookID` = ?)";
		jdbcConnection = MySqlCon.connectDb();
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id);
		statement.setInt(2, amount);
		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		MySqlCon.disconnect(jdbcConnection);
		return rowUpdated;
	}

}
