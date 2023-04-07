package com.tpq.service;

import java.sql.SQLException;
import java.util.ArrayList;
import com.tpq.dao.BookDAO;
import com.tpq.dao.BookDAOImpl;
import com.tpq.dao.CommonDAO;
import com.tpq.dto.BookDTO;

public class BookServiceImpl implements CommonService<BookDTO>, BookService {
  private CommonDAO<BookDTO> bookDAO;
  private BookDAO bookCheckDAO;

  // studentDAO = new StudentDAOImpl();

  public BookServiceImpl() {
    this.bookDAO = new BookDAOImpl();
    this.bookCheckDAO = new BookDAOImpl();
  }

  @Override
  public ArrayList<BookDTO> list() throws SQLException {
    return this.bookDAO.list();
  }

  @Override
  public boolean add(BookDTO data) throws SQLException {
    int check = checkNameBook(data.getName());
    if (check != 0)
      return false;
    return this.bookDAO.add(data);
  }

  @Override
  public boolean update(BookDTO data) throws SQLException {
    return this.bookDAO.update(data);
  }

  @Override
  public boolean delete(int id) throws SQLException {
    if (inUsed(id) > 0)
      return false;
    return this.bookDAO.delete(id);
  }

  @Override
  public BookDTO get(int id) throws SQLException {
    return this.bookDAO.get(id);
  }

  @Override
  public int inUsed(int id) throws SQLException {
    return this.bookDAO.inUsed(id);
  }

  @Override
  public int checkNameBook(String name) throws SQLException {
    return this.bookCheckDAO.checkNameBook(name);
  }

}
