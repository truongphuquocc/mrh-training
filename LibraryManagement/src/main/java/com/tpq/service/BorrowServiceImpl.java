package com.tpq.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.tpq.dao.BorrowDAO;
import com.tpq.dao.BorrowDAOImpl;
import com.tpq.dto.BookDTO;
import com.tpq.dto.BorrowDTO;

public class BorrowServiceImpl implements BorrowService<BorrowDTO> {

	private BorrowDAO<BorrowDTO> borrowDAO;

	/**
	 * 
	 */
	public BorrowServiceImpl() {
		this.borrowDAO = new BorrowDAOImpl();
	}

	@Override
	public ArrayList<BorrowDTO> list(String searchValue, String fromDay, String toDay) throws SQLException {
		return this.borrowDAO.list(searchValue, fromDay, toDay);
	}

	@Override
	public boolean add(BorrowDTO data) throws SQLException {
		if (data.getQuantity() <= 0)
			return false;
		updateAmount(data.getBookID(), data.getQuantity());
		return this.borrowDAO.add(data);
	}

	@Override
	public boolean updateAmount(int id, int amount) throws SQLException {
		return this.borrowDAO.updateAnount(id, amount);
	}

}
